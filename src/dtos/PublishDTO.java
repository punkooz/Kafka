package dtos;

public class PublishDTO {

    String producerId;
    String message;
    String topicId;

    public PublishDTO(String producerId, String message, String topicId) {
        this.producerId = producerId;
        this.message = message;
        this.topicId = topicId;
    }

    public String getProducerId() {
        return producerId;
    }

    public String getMessage() {
        return message;
    }

    public String getTopicId() {
        return topicId;
    }
}
