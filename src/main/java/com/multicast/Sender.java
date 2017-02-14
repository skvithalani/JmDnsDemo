package com.multicast;

import java.io.IOException;
import java.net.*;

public class Sender {
    public static void main(String[] args) {
        int port = 1234;
        String mcIpAddr = "239.255.255.250";
        try {
            InetAddress mcAddress = InetAddress.getByName(mcIpAddr);

            DatagramPacket packet = new DatagramPacket("Hello".getBytes(), 5);
            packet.setAddress(mcAddress);
            packet.setPort(port);

            System.out.println(InetAddress.getLocalHost());

            DatagramSocket udpSocket = new DatagramSocket();
            udpSocket.send(packet);

            System.out.println("Sent the message");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
