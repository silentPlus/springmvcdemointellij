package com.suvan.mongodb.thread;

import com.mongodb.*;

/**
 * Created by suvan on 2017/5/12.
 * mongo driver 2.13.0
 */
public class TestMongoDriver2 {
    public static void main(String[] args) {
        testCRUD();
    }

    public static void testCRUD() {
        Mongo mongo = null;
        try {
            mongo = new Mongo("10.80.18.214", 27017);
            DB db = mongo.getDB("jk");
            DBObject condition = new BasicDBObject();
            DBCollection coll = db.getCollection("320_890_linux_cpu");
            condition.put("_id", new BasicDBObject("$gte",  "170703100000").append("$lte", "170703105959"));
            DBCursor cur = coll.find(condition);
            while (cur.hasNext()) {
                DBObject oneDB = cur.next();
                System.out.println(oneDB.get("_id") + "::" + oneDB.get("cpu_rate"));
            }
            /*Set<String> colls = db.getCollectionNames();
            for (String s : colls) {
                System.out.println(s);
                if (!s.equals("system.indexes")) {
                    db.getCollection(s).drop();
                }
            }

            DBCollection coll = db.getCollection("1_1_linux_cpu");
            DBCursor dbCursor = coll.find();
            for (DBObject dbObject : dbCursor) {
                coll.remove(dbObject);
            }

            BasicDBObject doc = new BasicDBObject("name", "suvan")
                    .append("gender", "女")
                    .append("address", new BasicDBObject("postcode", "201202"));
            coll.insert(doc);

            BasicDBObject docFind = new BasicDBObject("name", "suvan");
            DBObject findResult = coll.findOne(docFind);
            System.out.println(findResult);

            doc.put("gender", "Fmale");
            coll.update(docFind, doc);
            findResult = coll.findOne(docFind);
            System.out.println(findResult);

            coll.dropIndexes();
            coll.createIndex(new BasicDBObject("name", 1));*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mongo != null) {
                mongo.close();
            }
        }
    }
}
