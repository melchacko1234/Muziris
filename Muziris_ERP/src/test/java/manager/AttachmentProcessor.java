package manager;

public interface AttachmentProcessor<T extends AttachmentData> {

    void addAttachment(T attachmentData, AttachmentRenderer<T> renderer);

}