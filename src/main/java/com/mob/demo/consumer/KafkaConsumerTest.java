package com.mob.demo.consumer;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
/**
 * @author taozhq
 * kafka相关操作
 *
 */
@SuppressWarnings("all")
public class KafkaConsumerTest {    
    
    public static void main(String[] args) {    
                // specify some consumer properties    
        Properties props = new Properties();    
        props.put("zookeeper.connect", "10.18.97.61:2181");    
        props.put("zookeeper.connectiontimeout.ms", "1000000");    
        props.put("group.id", "test_group");  
        props.put("zookeeper.session.timeout.ms", "40000");  
        props.put("zookeeper.sync.time.ms", "200");  
        props.put("auto.commit.interval.ms", "1000");  
    
                // Create the connection to the cluster    
        ConsumerConfig consumerConfig = new ConsumerConfig(props);    
        ConsumerConnector consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);    
    
                // create 4 partitions of the stream for topic “test-topic”, to allow 4 threads to consume    
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();    
        topicCountMap.put("test", new Integer(4));    
        //key--topic    
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap =   
                consumerConnector.createMessageStreams(topicCountMap);  
        KafkaStream<byte[], byte[]> stream = consumerMap.get("test").get(0);  
        ConsumerIterator<byte[], byte[]> it = stream.iterator();  
		StringBuffer sb = new StringBuffer();  
        while(it.hasNext()){  
            try {  
                String msg = new String(it.next().message(), "utf-8").trim();  
                System.out.println("receive:" + msg);  
            } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
            }  
        }  
         
    }
}