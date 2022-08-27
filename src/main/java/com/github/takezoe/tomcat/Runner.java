package com.github.takezoe.tomcat;

import java.io.File;
import org.apache.catalina.startup.Tomcat;

public class Runner
{
    public static void main(String[] args) throws Exception
    {
        Tomcat tomcat = new Tomcat();

        for(int i = 0; i < args.length; i++) {
            if (args[i].equals("--port") && args.length > i + 1) {
                int port = Integer.parseInt(args[i + 1]);
                tomcat.setPort(port);
                i = i + 1;
            }
            else {
                String context = args[i + 1];
                tomcat.addWebapp("/", new File(context).getAbsolutePath());
            }
        }

        tomcat.getConnector();
        tomcat.start();
        tomcat.getServer().await();
    }
}
