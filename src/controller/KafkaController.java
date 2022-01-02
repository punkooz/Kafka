package controller;

import dtos.PublishDTO;
import entities.Consumer;
import entities.Producer;
import entities.Topic;
import repositories.ConsumerRepo;
import repositories.ProducerRepo;
import repositories.TopicRepo;
import services.KafkaService;

public class KafkaController {

    ConsumerRepo consumerRepo = new ConsumerRepo();
    TopicRepo topicRepo = new TopicRepo();
    ProducerRepo producerRepo = new ProducerRepo();

    KafkaService kafkaService = new KafkaService(consumerRepo, topicRepo, producerRepo);

    public void createTopic(String topicId){
        topicRepo.saveTopic(new Topic(topicId));
    }

    public void createProducers(String producerId){
        producerRepo.saveProducer(new Producer(producerId));
    }

    public void createConsumers(String consumerId){
        consumerRepo.saveConsumer(new Consumer(consumerId));
    }

    public void subscribeToTopic(String consumerId, String topicId){
        kafkaService.subscribe(consumerId, topicId);
    }

    public void publishToTopic(PublishDTO publishDTO){
        kafkaService.publish(publishDTO);
    }

}
