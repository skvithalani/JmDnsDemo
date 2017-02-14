package com.jmdns;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;

public class DiscoverService implements Runnable {

    public static void main(String[] args) {

        new Thread(new DiscoverService()).start();

    }
    private void discover() {
        try {
            JmDNS jmDNS = JmDNS.create();
            for(ServiceInfo service : jmDNS.list("_tmt._tcp.local.")) {
                System.out.println(service);
            }
            System.out.println(jmDNS.list("_printer._tcp.local.").length);
            jmDNS.addServiceListener("_printer._tcp.local.", new ServiceListener() {
                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("added");
                    System.out.println("----------------------------------------------"+event.getInfo());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("removed");
                    System.out.println("----------------------------------------------"+event.getInfo());

                }

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("resolved");
                    System.out.println("----------------------------------------------"+event.getInfo());

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            discover();
        }
    }
}
