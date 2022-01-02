package repositories;

import entities.Topic;

import java.util.HashMap;

public class TopicRepo {

    HashMap<String, Topic> topicHashMap;

    public TopicRepo() {
        this.topicHashMap = new HashMap<>();
    }

    public HashMap<String, Topic> getTopicHashMap() {
        return topicHashMap;
    }

    public void saveTopic(Topic topic){
        topicHashMap.put(topic.getTopicId(), topic);
    }

    public Topic getTopicById(String id){
        return topicHashMap.get(id);
    }
}
