package com.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Reciever {
    public static void main(String[] args) {
        int port = 1234;
        String mcAddr = "239.255.255.250";

        try {
            InetAddress mcAddress = InetAddress.getByName(mcAddr);
            MulticastSocket socket = new MulticastSocket(port);
            System.out.println("Multicast reciever running at " + socket.getLocalSocketAddress() + " - " + socket.getTimeToLive());
            socket.joinGroup(mcAddress);

            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            System.out.println("Waiting for a  multicast message...");
            socket.receive(packet);

            String msg = new String(packet.getData(), packet.getOffset(),
                    packet.getLength());
            System.out.println("[Multicast  Receiver] Received:" + msg);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
