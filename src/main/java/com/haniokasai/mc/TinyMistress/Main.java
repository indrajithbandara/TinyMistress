package com.haniokasai.mc.TinyMistress;
import com.haniokasai.mc.TinyMistress.srv.server;
import com.haniokasai.mc.TinyMistress.tools.TinyLogger;
import com.haniokasai.mc.TinyMistress.tools.config;
import com.haniokasai.mc.TinyMistress.web.WebSrv;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hani on 2017/03/01.
 */
public class Main{
    public static Map<String,server> servers = new HashMap<String,server>();

    static TinyLogger logger;
    public static config conf;
    public static boolean bl = true;
    public static void main(String args[]){

        logger = new TinyLogger();
        logger.elog("hello world");
        conf = new config();
       // main.test();
        (new WebSrv()).start();
        servers.put("a",new server());
        servers.get("a").start();

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            //mysql.shutdown();
            servers.get("a").kill();
            System.out.println("shutdown..");
        }
        ));
        //mysql.load();

    }

}