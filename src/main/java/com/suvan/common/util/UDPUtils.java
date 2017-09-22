package com.suvan.common.util;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by suvan on 2017/9/22.
 */
public class UDPUtils {

    private final static int PORT = 14;
    private static final String IP = "127.0.0.1";

    public static void main(String[] args) throws Exception{
        ServerUDP server = new ServerUDP();
        Thread thread = new Thread(server);
        thread.start();
    }

    public static void send(String msg, int port) {
        byte[] buf = msg.getBytes();
        //传入0表示让操作系统分配一个端口号
        try (DatagramSocket socket = new DatagramSocket(port)) {
            socket.setSoTimeout(10000);
            InetAddress host = InetAddress.getLocalHost();
            //指定包要发送的目的地
            DatagramPacket request = new DatagramPacket(buf, buf.length, host, PORT);
            socket.send(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerUDP implements Runnable{

    @Override
    public void run() {
        System.out.println("开始接收信息");
        try (DatagramSocket socket = new DatagramSocket(14)) {
            while (true) {
                try {
                    byte[] buf = new byte[1024];
                    DatagramPacket request = new DatagramPacket(buf, buf.length);
                    socket.receive(request);
                    String msg = new String(buf, 0, request.getLength());
                    System.out.println("接收到发送的数据为：" + msg);
                    if ("exit".equals(msg)) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("结束接收信息");
    }
}
