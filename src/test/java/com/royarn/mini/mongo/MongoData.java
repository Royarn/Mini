//package com.royarn.mini.mongo;
//
//
//import com.mongodb.MongoClient;
//import com.mongodb.client.*;
//import org.bson.Document;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author lizq
// * @Description: ${todo}
// * @date 2018/7/10 20:13
// */
//public class MongoData {
//
//    public static void main(String[] args) throws InterruptedException {
//        //客户端连接
//        MongoClient client = new MongoClient("192.168.12.78", 9090);
//
//        //连接到数据库
//        MongoDatabase database = client.getDatabase("np_config");
//        System.out.println("Connect to database successfully ... ");
//
//        MongoCollection<Document> collection = database.getCollection("dev_device_camera");
//        System.out.println("choose collection successfully ... ");
//
//
//        //创建索引
////        collection.createIndex(new BasicDBObject("device_id", "1").append("unique", true));
////        collection.createIndex(new BasicDBObject("sort", "1").append("unique", true));
////        collection.createIndex(new BasicDBObject("group_id", "1"));
////        collection.createIndex(new BasicDBObject("merge", "1"));
////        collection.createIndex(new BasicDBObject("node_id", "1"));
////        collection.createIndex(new BasicDBObject("relation_id", "1"));
////        collection.createIndex(new BasicDBObject("from_group_id", "1"));
//
//        ListIndexesIterable<Document> list  = collection.listIndexes();
//        for (Document temp : list) {
//            System.out.println(temp.toJson());
//        }
//
//        //获取数据
////        FindIterable<Document> iterable = collection.find();
////        MongoCursor<Document> cursor = iterable.iterator();
////        while (cursor.hasNext()) {
////            System.out.println(cursor.next());
////        }
//
//        List<Document> documents = new ArrayList<>();
//
//        long startTime = System.currentTimeMillis();
//        for (long i =10100001;i<20100001;i++) {
//            Document document = new Document()
//                    .append("id", "00GA00GA018gwH1" + i)
//                    .append("camera_no", "0000001")
//                    .append("name", "test_name_" + i)
//                    .append("pin_yin", "1.1.20.149")
//                    .append("pin_yin_ad", "1.1.20.149")
//                    .append("level", "0")
//                    .append("cid", "")
//                    .append("node_id", "a7e850fc-e260-4cf8-a7d2-225" + i)
//                    .append("group_id", "b64cafa-1d28-4a7-b3d11-d98" + i)
//                    .append("device_id", "b64ccafa-1d28-4a27-bd11-d982" + i)
//                    .append("device_type", "0")
//                    .append("chan_no", "1")
//                    .append("chan_param", "")
//                    .append("gb_id", "")
//                    .append("dpi", "")
//                    .append("ptz", "")
//                    .append("longitude", "")
//                    .append("latitude", "")
//                    .append("merge", i)
//                    .append("ext", "")
//                    .append("type", "local")
//                    .append("status", "")
//                    .append("relation_id", i)
//                    .append("from_group_id", i)
//                    .append("from_merge", i)
//                    .append("transport", "")
//                    .append("sort", i)
//                    .append("path", "")
//                    .append("manufacturer", "")
//                    .append("model", "")
//                    .append("owner", "")
//                    .append("block", "")
//                    .append("address", "")
//                    .append("parental", "")
//                    .append("safetyway", "")
//                    .append("secrecy", "")
//                    .append("position", "")
//                    .append("room", "1")
//                    .append("uses", "")
//                    .append("supplylight", "")
//                    .append("direction", "")
//                    .append("stream_number", "")
//                    .append("analog_type", "")
//                    .append("modify_time", "2018-07-04 14:27:56")
//                    .append("mac", "")
//                    .append("version", "")
//                    .append("is_local", "1")
//                    .append("chan_sort", "/00001");
//            //documents.add(document);
//            collection.insertOne(document);
//        }
//
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("耗时时间： " + (endTime - startTime) + " ms");
////        //获取数据
////        FindIterable<Document> iterable = collection.find();
////        MongoCursor<Document> cursor = iterable.iterator();
////        while (cursor.hasNext()) {
////            System.out.println(cursor.next());
////        }
//    }
//}
