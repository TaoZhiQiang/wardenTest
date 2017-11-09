package com.mob.demo.producer;
import java.util.Properties;  
import kafka.javaapi.producer.Producer;  
import kafka.producer.KeyedMessage;  
import kafka.producer.ProducerConfig;  
  
public class KafkaProducerTest {  
      
    String topic = "test";  
      
    public static void main(String[] args) {  
        Properties props = new Properties();  
//      props.put("zookeeper.connect", "10.18.97.61:2181");  
        props.put("serializer.class", "kafka.serializer.StringEncoder");  
        props.put("producer.type", "async");//default is sync  
        props.put("compression.codec", "1");  
        props.put("metadata.broker.list", "10.18.97.61:9092");  
        ProducerConfig config = new ProducerConfig(props);  
          
        Producer<String, Object> producer = new Producer<String, Object>(config);  
        KeyedMessage<String, Object> message =   
                new KeyedMessage<String, Object>("test", "hello world");  
          
        producer.send(message);  
    } 
}