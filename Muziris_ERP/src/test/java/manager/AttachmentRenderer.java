package manager;

@SuppressWarnings("PMD.AvoidUncheckedExceptionsInSignatures")
public interface AttachmentRenderer<T extends AttachmentData> {

    AttachmentContent render(T attachmentData) throws AttachmentRenderException;

}