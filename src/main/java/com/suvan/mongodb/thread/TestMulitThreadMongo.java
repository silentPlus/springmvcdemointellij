package com.suvan.mongodb.thread;

import com.mongodb.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by suvan on 2017/5/12.
 * mongo driver 2.13.0
 */
public class TestMulitThreadMongo {
    public static void main(String[] args) {
        System.out.println("开始");
        try {
            final SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
            final Calendar c = Calendar.getInstance();
            final Date nowDate = new Date();
            MongoOptions opt = new MongoOptions();
            opt.connectionsPerHost = 500;
            opt.threadsAllowedToBlockForConnectionMultiplier = 100;
            Mongo mongo = null;
            mongo = new Mongo(new ServerAddress("localhost", 27017), opt);
            DB db = mongo.getDB("jk");
            for (int j = 1; j <=40; j++) {
                String colltions = j + "_" + j + "_linux_cpu";
                final DBCollection coll = db.getCollection(colltions);

                new Thread() {
                    public void run() {
                        try {
                            int count = 1;
                            while (count <= 80000) {
                                c.setTime(nowDate);
                                c.add(Calendar.MINUTE, -count*2);
                                BasicDBObject doc = new BasicDBObject();
                                doc.put("_id", formatter.format(c.getTime()));
                                doc.put("cpu_rate", String.format("%.2f", (Math.random() * 100)));
                                coll.insert(doc);
                                count++;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
