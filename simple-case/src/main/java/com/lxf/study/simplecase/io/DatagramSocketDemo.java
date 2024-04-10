package com.lxf.study.simplecase.io;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DatagramSocketDemo {


    public static class Server {

        private DatagramSocket ds;

        public Server() {
            try {
                ds = new DatagramSocket(6666); // 监听指定端口
            } catch (SocketException e) {
                throw new RuntimeException(e);
            }
        }

        public void start() throws IOException {
            for (; ; ) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                ds.receive(packet);
                String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
                System.out.println(s);
                byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
                packet.setData(data);
                ds.send(packet);
            }
        }

    }


    public static class Client {
        private DatagramSocket ds;

        public Client() {
            try {
                ds = new DatagramSocket();
                ds.connect(InetAddress.getByName("localhost"), 6666);
            } catch (SocketException | UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }

        public void start() throws IOException {
            byte[] data = "Hello".getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length);
            ds.send(packet);
            byte[] buffer = new byte[1024];
            packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet);
            String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println(resp);
            ds.disconnect();
            ds.close();
        }

    }


    public static void main(String[] args) {

        new Thread(() -> {
            Server server = new Server();
            try {
                server.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();


        new Thread(() -> {
            Client client = new Client();
            try {
                client.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
        
    }


}
