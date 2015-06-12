package de.cynapsys.homeautomation.upnp;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.teleal.cling.DefaultUpnpServiceConfiguration;
import org.teleal.cling.UpnpService;
import org.teleal.cling.UpnpServiceImpl;
import org.teleal.cling.model.meta.Action;
import org.teleal.cling.model.meta.ActionArgument;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.model.meta.Service;
import org.teleal.cling.model.types.UDAServiceId;
import org.teleal.cling.registry.DefaultRegistryListener;
import org.teleal.cling.registry.Registry;
import org.teleal.cling.registry.RegistryListener;
import org.teleal.cling.support.igd.PortMappingListener;
import org.teleal.cling.support.model.PortMapping;
import org.teleal.cling.transport.impl.StreamClientConfigurationImpl;
import org.teleal.cling.transport.impl.StreamClientImpl;
import org.teleal.cling.transport.impl.StreamServerConfigurationImpl;
import org.teleal.cling.transport.impl.StreamServerImpl;
import org.teleal.cling.transport.spi.NetworkAddressFactory;
import org.teleal.cling.transport.spi.StreamClient;
import org.teleal.cling.transport.spi.StreamServer;

/**
 * Handles UPnP calls needed for the server to automatically open a port on a
 * router.
 *
 * @author DrLabman
 */
public class UPnP {

    private static UpnpService upnpService = null;

    /**
     * Start up the upnpService and register the port
     *
     * @param port
     */
    public static void RegisterPort(int port) {
        if (upnpService != null) {
            UnregisterPort();
        }

        String ipAddr = IPUtil.getInternalIPAddress();
        if (ipAddr != null) {
            // Port Mapping
            try{
            PortMapping desiredMapping = new PortMapping(port, ipAddr, PortMapping.Protocol.TCP, "Home Automation Port Mapping");
            upnpService = new UpnpServiceImpl(new PortMappingListener(desiredMapping));

            System.out.println(upnpService.getRouter());
            upnpService.getControlPoint().search();
            }
            catch(Exception e){e.printStackTrace();}
        } else {
        }
    }

    
    /********
     * if port is open then getPortStatus return true 
     * @param port
     * @return 
     */
    public static boolean getPortStatus(int port) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", port), 200);
            socket.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Shutdown the upnpService to unregister the port mapping.
     */
    public static void UnregisterPort() {
        if (upnpService != null) {
            upnpService.shutdown();
        }

        upnpService = null;
    }

}
