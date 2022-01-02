package services;

import dtos.PublishDTO;
import entities.Consumer;
import entities.Producer;
import entities.Topic;
import repositories.ConsumerRepo;
import repositories.ProducerRepo;
import repositories.TopicRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KafkaService {

    ConsumerRepo consumerRepo;
    TopicRepo topicRepo;
    ProducerRepo producerRepo;

    public KafkaService(ConsumerRepo consumerRepo, TopicRepo topicRepo, ProducerRepo producerRepo) {
        this.consumerRepo = consumerRepo;
        this.topicRepo = topicRepo;
        this.producerRepo = producerRepo;
    }


    public void subscribe(String consumerId, String topicId) {

        Topic topic = topicRepo.getTopicById(topicId);

        List<Consumer> consumerList = topic.getConsumerList();

        if (consumerList == null){
            consumerList = new ArrayList<>();
        }

        Consumer consumer = consumerRepo.getConsumerById(consumerId);

        consumerList.add(consumer);

        topic.setConsumerList(consumerList);

        topicRepo.saveTopic(topic);
    }

//    public void publishToTopics(String producerId, String topicId){
//        Producer producer = producerRepo.getProducerById(producerId);
//        HashMap<String, Topic> topicHashMap = producer.getTopicHashMap();
//        Topic topic = topicRepo.getTopicById(topicId);
//        topicHashMap.put(topic.getTopicId(), topic);
//        producer.setTopicHashMap(topicHashMap);
//        producerRepo.saveProducer(producer);
//    }

    public void publish(PublishDTO publishDTO){

        String producerId = publishDTO.getProducerId();
        String message = publishDTO.getMessage();
        String topicId = publishDTO.getTopicId();


        Producer producer = producerRepo.getProducerById(producerId);

        Topic topic = topicRepo.getTopicById(topicId);

        topic.setNewMessage(message);

        HashMap<String, Topic> topicHashMap = producer.getTopicHashMap();

        topicHashMap.put(topicId, topic);

        producer.setTopicHashMap(topicHashMap);

        producerRepo.saveProducer(producer);
    }

}
