package entities;

public class Consumer {

    String consumerId;

    public Consumer(String consumerId) {
        this.consumerId = consumerId;
    }

    public void notifyNewMessage(String message){
        System.out.println("Consumer Id: " + consumerId + ", message: " + message);
    }

    public String getConsumerId() {
        return consumerId;
    }
}
