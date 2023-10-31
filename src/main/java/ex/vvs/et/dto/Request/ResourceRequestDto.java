package ex.vvs.et.dto.Request;

public class ResourceRequestDto {
private Long Id;
    private Integer resourceTypeId;
    private String name;
    private String description;
    private String status;

    public ResourceRequestDto() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Integer resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
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
}
