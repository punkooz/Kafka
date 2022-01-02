package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Producer {

    String producerId;
    HashMap<String, Topic> topicHashMap;

    public Producer(String producerId) {
        this.producerId = producerId;
        this.topicHashMap = new HashMap<>();
    }

    public String getProducerId() {
        return producerId;
    }

    public HashMap<String, Topic> getTopicHashMap() {
        return topicHashMap;
    }

    public void setTopicHashMap(HashMap<String, Topic> topicHashMap) {
        this.topicHashMap = topicHashMap;
    }

    public Topic getTopicById(String topicId){
        return topicHashMap.get(topicId);
    }
}
