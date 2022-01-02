package repositories;

import entities.Consumer;

import java.util.HashMap;

public class ConsumerRepo {

    HashMap<String, Consumer> consumerHashMap;

    public ConsumerRepo() {
        this.consumerHashMap = new HashMap<>();
    }

    public HashMap<String, Consumer> getConsumerHashMap() {
        return consumerHashMap;
    }

    public void saveConsumer(Consumer consumer){
        consumerHashMap.put(consumer.getConsumerId(), consumer);
    }

    public Consumer getConsumerById(String id){
       return consumerHashMap.get(id);
    }
}
