package com.suvan.mongodb.thread;

import com.mongodb.*;

/**
 * Created by suvan on 2017/5/12.
 * mongo driver 2.13.0
 */
public class TestMulitThreadMongo {
    public static void main(String[] args) {

        try {
            MongoOptions opt = new MongoOptions();
            opt.connectionsPerHost = 500;
            opt.threadsAllowedToBlockForConnectionMultiplier = 100;
            Mongo mongo = null;
            mongo = new Mongo(new ServerAddress("localhost", 27017), opt);
            DB db = mongo.getDB("threadtest");
            final DBCollection coll = db.getCollection("test_01");

            for(int i=0;i<5000;i++){
                new Thread(){
                    public void run(){
                        try {
                            int count = 0;
                            while (count < 100) {
                                BasicDBObject doc = new BasicDBObject("age", count);
                                coll.insert(doc);
                                count++;
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
