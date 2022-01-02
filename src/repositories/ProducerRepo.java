package repositories;

import dtos.PublishDTO;
import entities.Producer;

import java.util.HashMap;

public class ProducerRepo {

    HashMap<String, Producer> producerHashMap;

    public ProducerRepo() {
        this.producerHashMap = new HashMap<>();
    }

    public void saveProducer(Producer producer){
        producerHashMap.put(producer.getProducerId(), producer);
    }

    public Producer getProducerById(String id){
       return producerHashMap.get(id);
    }

    public HashMap<String, Producer> getProducerHashMap() {
        return producerHashMap;
    }
}
