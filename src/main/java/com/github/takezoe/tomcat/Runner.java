package com.github.takezoe.tomcat;

import java.io.File;
import org.apache.catalina.startup.Tomcat;

public class Runner
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("===============================");
        int port = 8080;
        String webappDirLocation = "";
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        for(int i = 0; i < args.length; i++) {
            if (args[i].equals("--port") && args.length > i + 1) {
                port = Integer.parseInt(args[i + 1]);
                i++;
            }
            else {
                webappDirLocation = args[i];
            }
        }
        System.out.println("===============================");

        Tomcat tomcat = new Tomcat();
        System.out.println("configuring port: " + port);
        tomcat.setPort(port);
        tomcat.getConnector();

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
