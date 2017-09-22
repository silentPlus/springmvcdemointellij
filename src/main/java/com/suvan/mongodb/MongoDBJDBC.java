package com.suvan.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suvan on 2017/5/4.
 * mongo driver 最新 3.4.2
 */
public class MongoDBJDBC {
    public static void main(String[] args) throws Exception{
        // 直接连接单个MongoDB服务器
        // 如果他是一个副本集成员，该操作也不会自动连接主服务器
        // MongoClient mongoClient1 = new MongoClient();
        // // or
        // MongoClient mongoClient2 = new MongoClient( "localhost" );
        // or
        // MongoClient mongoClient3 = new MongoClient( "10.80.18.214" , 27017 );

        // 在提供的地址列表中自动选择连接到一个副本集
        // MongoClient mongoClient4 = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
        //         new ServerAddress("localhost", 27018),
        //         new ServerAddress("localhost", 27019)));
        // or
        ServerAddress serverAddress = new ServerAddress("10.80.18.214", 27017);
        List<ServerAddress> serverAddressList = new ArrayList<>();
        serverAddressList.add(serverAddress);
        MongoCredential credential = MongoCredential.createScramSha1Credential("userName", "test", "password".toCharArray());
        List<MongoCredential> mongoCredentialList = new ArrayList<>();
        mongoCredentialList.add(credential);
        MongoClient mongoClient5 = new MongoClient(serverAddressList, mongoCredentialList);

        // MongoDatabase mongoDatabase = mongoClient1.getDatabase("test");
        // MongoCollection collection = mongoDatabase.getCollection("test_2017_05_15");

    }
}
