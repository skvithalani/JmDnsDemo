package com.jmdns;

import javax.jmdns.*;
import java.io.IOException;

public class RegisterService {
    public static void main(String[] args) {

        try {
            JmDNS jmDNS = JmDNS.create();
            System.out.println(jmDNS);
            ServiceInfo service = ServiceInfo.create("_tmt._tcp.local.", "tmt3", 516, "");
            ServiceInfo service1 = ServiceInfo.create("_tmt._tcp.local.", "tmt4", 517, "");
            jmDNS.registerService(service);
            jmDNS.registerService(service1);

            ServiceInfo[] allServices = jmDNS.list("_tmt._tcp.local.");
            ServiceInfo[] printerServices = jmDNS.list("_printer._tcp.local.");

            printServices(allServices);
            printServices(printerServices);
            jmDNS.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printServices(ServiceInfo[] allServices) {
        for (ServiceInfo allService : allServices) {
            System.out.println(allService);
        }
    }

    private static class ServiceListener1 implements ServiceListener {

        @Override
        public void serviceAdded(ServiceEvent event) {
            System.out.println("yo -----------" + event);
        }

        @Override
        public void serviceRemoved(ServiceEvent event) {

        }

        @Override
        public void serviceResolved(ServiceEvent event) {

        }
    }
}
