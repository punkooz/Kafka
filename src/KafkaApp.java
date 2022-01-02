import controller.KafkaController;
import dtos.PublishDTO;

public class KafkaApp {

    public static void main(String[] args) {

        KafkaController kafkaController = new KafkaController();

        kafkaController.createTopic("topic1");
        kafkaController.createTopic("topic2");

        kafkaController.createProducers("producer1");
        kafkaController.createProducers("producer2");

        kafkaController.createConsumers("consumer1");
        kafkaController.createConsumers("consumer2");
        kafkaController.createConsumers("consumer3");
        kafkaController.createConsumers("consumer4");
        kafkaController.createConsumers("consumer5");

        //subscribing to topic 1
        kafkaController.subscribeToTopic("consumer1", "topic1");
        kafkaController.subscribeToTopic("consumer2", "topic1");
        kafkaController.subscribeToTopic("consumer3", "topic1");
        kafkaController.subscribeToTopic("consumer4", "topic1");
        kafkaController.subscribeToTopic("consumer5", "topic1");

        //subscribing to topic 2
        kafkaController.subscribeToTopic("consumer1", "topic2");
        kafkaController.subscribeToTopic("consumer3", "topic2");
        kafkaController.subscribeToTopic("consumer4", "topic2");

        //publishing message
        kafkaController.publishToTopic(new PublishDTO("producer1", "Message 1", "topic1"));
        kafkaController.publishToTopic(new PublishDTO("producer1", "Message 2", "topic1"));
        kafkaController.publishToTopic(new PublishDTO("producer2", "Message 3", "topic1"));
        kafkaController.publishToTopic(new PublishDTO("producer1", "Message 4", "topic2"));
        kafkaController.publishToTopic(new PublishDTO("producer2", "Message 5", "topic2"));

    }

}
