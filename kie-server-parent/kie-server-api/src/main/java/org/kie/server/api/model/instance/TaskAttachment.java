package org.kie.server.api.model.instance;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "task-attachment")
public class TaskAttachment {

    @XmlElement(name="attachment-id")
    private Long id;

    @XmlElement(name="attachment-name")
    private String name;

    @XmlElement(name="attachment-added-by")
    private String addedBy;

    @XmlElement(name="attachment-added-at")
    private Date addedAt;

    @XmlElement(name="attachment-type")
    private String contentType;

    @XmlElement(name="attachment-size")
    private Integer size;

    @XmlElement(name="attachment-content-id")
    private Long attachmentContentId;

    public TaskAttachment() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getAttachmentContentId() {
        return attachmentContentId;
    }

    public void setAttachmentContentId(Long attachmentContentId) {
        this.attachmentContentId = attachmentContentId;
    }

    @Override public String toString() {
        return "TaskAttachment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addedBy='" + addedBy + '\'' +
                ", addedAt=" + addedAt +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
                ", attachmentContentId=" + attachmentContentId +
                '}';
    }

    public static class Builder {

        private TaskAttachment comment = new TaskAttachment();

        public TaskAttachment build() {
            return comment;
        }

        public Builder id(Long id) {
            comment.setId(id);
            return this;
        }

        public Builder name(String name) {
            comment.setName(name);
            return this;
        }

        public Builder addedBy(String addedBy) {
            comment.setAddedBy(addedBy);
            return this;
        }

        public Builder addedAt(Date addedAt) {
            comment.setAddedAt(addedAt);
            return this;
        }

        public Builder contentType(String contentType) {
            comment.setContentType(contentType);
            return this;
        }

        public Builder size(Integer size) {
            comment.setSize(size);
            return this;
        }

        public Builder attachmentContentId(Long attachmentContentId) {
            comment.setAttachmentContentId(attachmentContentId);
            return this;
        }
    }

}
