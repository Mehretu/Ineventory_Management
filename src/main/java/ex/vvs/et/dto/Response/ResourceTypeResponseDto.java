package ex.vvs.et.dto.Response;

import java.util.Date;

public class ResourceTypeResponseDto {
    private int id;
    private String name;
    private Date createdOn;
    private Date updatedOn;

    public ResourceTypeResponseDto() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public ResourceTypeResponseDto(int id, String name, Date createdOn, Date updatedOn) {
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }
}
