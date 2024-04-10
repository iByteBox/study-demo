package com.lxf.study.simplecase.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MsgServer {

    private List<Socket> clients = new CopyOnWriteArrayList<>();

    private ServerSocket serverSocket;

    public MsgServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MsgServer server = new MsgServer(8899);
        server.handlerConnect();
    }

    public void handlerConnect() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(">>>客户端连接");
                clients.add(socket);
                new Thread(() -> {
                    try {
                        while (true) {
                            String msg = getMsg(socket);
                            System.out.println(">>>收到客户端消息:" + msg);
                            transpond(msg);
                        }
                    } catch (IOException e) {
                        // throw new RuntimeException(e);
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getMsg(Socket c) throws IOException {
        InputStream is = c.getInputStream();
        int len = is.read();
        byte[] data = is.readNBytes(len);
        String msg = new String(data, StandardCharsets.UTF_8);
        if (msg.equals("@quit")) {
            c.close();
            clients.remove(c);
            msg = " bye bye!";
        }
        return msg;
    }

    private void transpond(String msg) throws IOException {
        for (Socket c : clients) {
            if (c.isClosed()) {
                continue;
            }
            OutputStream os = c.getOutputStream();
            os.write(msg.length());
            os.write(msg.getBytes(StandardCharsets.UTF_8));
            os.flush();
        }
    }
}
