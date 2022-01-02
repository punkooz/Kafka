package entities;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    String topicId;
    String message;
    List<Consumer> consumerList;

    public Topic(String topicId) {
        this.topicId = topicId;
        this.consumerList = new ArrayList<>();
    }

    public void setNewMessage(String message) {
        this.message = message;
        updateConsumers();
    }

    public List<Consumer> getConsumerList() {
        return consumerList;
    }

    public void setConsumerList(List<Consumer> consumerList) {
        this.consumerList = consumerList;
    }

    private void updateConsumers() {

        for (Consumer consumer : consumerList){
//            Thread obj = new Thread();
            consumer.notifyNewMessage(message);
        }

    }

    public String getTopicId() {
        return topicId;
    }
}
