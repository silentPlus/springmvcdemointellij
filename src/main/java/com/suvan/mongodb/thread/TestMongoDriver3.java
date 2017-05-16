package com.suvan.mongodb.thread;

/**
 * Created by suvan on 2017/5/12.
 * mongo driver 3.4.2
 */
public class TestMongoDriver3 {
    /*public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            // 单个数据库且不使用密码
            // Cluster created with settings {hosts=[localhost:27017], mode=SINGLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms', maxWaitQueueSize=500}
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            mongoClient = new MongoClient(serverAddress);

            // 多集群数据库，且使用密码
            // Cluster created with settings {hosts=[localhost:27017], mode=MULTIPLE, requiredClusterType=UNKNOWN, serverSelectionTimeout='30000 ms', maxWaitQueueSize=500}
            // Adding discovered server localhost:27017 to client view of cluster
            // ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            // List<ServerAddress> serverAddressList = new ArrayList<>();
            // serverAddressList.add(serverAddress);
            //
            // MongoCredential credential = MongoCredential.createScramSha1Credential("userName", "test", "password".toCharArray());
            // List<MongoCredential> mongoCredentialList = new ArrayList<>();
            // mongoCredentialList.add(credential);
            //
            // MongoClient mongoClient = new MongoClient(serverAddressList, mongoCredentialList);

            *//*指定数据库*//*
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");

            *//*创建collection*//*
            // mongoDatabase.createCollection("test");
            // System.out.println("Collection created successfully");

            *//*指定collection*//*
            MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("aaa");
            System.out.println("Collecton test selected successfully");

            *//*插入数据*//*
            // insert(mongoCollection);
            *//*检索所有文档*//*
            // find(mongoCollection);

            *//*更新文档*//*
            // update(mongoCollection);
            *//*检索所有文档*//*
            // find(mongoCollection);

            *//*删除文档*//*
            delete(mongoCollection);
            *//*检索所有文档*//*
            find(mongoCollection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }

    public static void insert(MongoCollection<Document> mongoCollection) {
        Document document1 = new Document("title", "MongoDB")
                .append("desc", "database")
                .append("likes", 1001)
                .append("by", "suvan");
        Document document2 = new Document("title", "MongoDB")
                .append("desc", "database")
                .append("likes", 3001)
                .append("by", "suvan");
        Document document3 = new Document("title", "java")
                .append("desc", "code")
                .append("likes", 1001)
                .append("by", "suvan");
        List<Document> documents = new ArrayList<>();
        documents.add(document1);
        documents.add(document2);
        documents.add(document3);
        mongoCollection.insertMany(documents);
        System.out.println("Document inserted successfully");
    }

    public static void find(MongoCollection<Document> mongoCollection) {
        FindIterable<Document> findIterable = mongoCollection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
    }

    public static void update(MongoCollection<Document> mongoCollection) {
        mongoCollection.updateMany(Filters.eq("likes", 300), new Document("$set", new Document("likes", 200)));
    }

    public static void delete(MongoCollection<Document> mongoCollection) {
        // mongoCollection.deleteOne(Filters.eq("likes", 200));
        mongoCollection.deleteMany(Filters.eq("likes", 200));
    }*/
}
