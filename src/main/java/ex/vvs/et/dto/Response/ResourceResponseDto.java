package ex.vvs.et.dto.Response;

import ex.vvs.et.model.ResourceType;

import java.util.Date;

public class ResourceResponseDto {


    private long id;
    private ResourceType resourceType;
    private String name;
    private String description;
    private String status;
    private Date createdOn;
    private Date updatedOn;
    private ResourceTypeResponseDto resourceTypeResponseDto;

    public ResourceTypeResponseDto getResourceTypeResponseDto() {
        return resourceTypeResponseDto;
    }



    public ResourceResponseDto() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void setResourceTypeResponseDto(ResourceTypeResponseDto resourceTypeResponseDto) {
        this.resourceTypeResponseDto = resourceTypeResponseDto;
    }
    public ResourceResponseDto(long id, ResourceType resourceType, String name, String description, String status, Date createdOn, Date updatedOn) {
        this.id = id;
        this.resourceType = resourceType;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

}
