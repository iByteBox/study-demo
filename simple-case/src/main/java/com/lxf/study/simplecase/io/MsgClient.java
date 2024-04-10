package com.lxf.study.simplecase.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MsgClient {

    private final Socket c;

    public MsgClient(String host, int port) {
        try {
            this.c = new Socket(host, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        MsgClient client = new MsgClient("localhost", 8899);

        Thread t0 = new Thread(() -> {
            while (!Thread.interrupted()) {
                client.showMsg();
            }
        });
        t0.start();

        Thread t1 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
            while (true) {
                String msg = scanner.nextLine();
                client.sendMsg(msg);
                if (msg.equals("@quit")) {
                    break;
                }
            }
        });
        t1.start();

    }

    public void showMsg() {
        try {
            InputStream is = c.getInputStream();
            int len = is.read();
            byte[] data = is.readNBytes(len);
            System.out.println("收到消息：" + new String(data, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMsg(String msg) {
        try {
            OutputStream os = c.getOutputStream();
            os.write(msg.length());
            os.write(msg.getBytes(StandardCharsets.UTF_8));
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
