package ex.vvs.et.dto.Response;

import java.util.Date;

public class DepartmentResponseDto {

    private long id;
    private String name;
    private Date createdOn;
    private Date updatedOn;
    private String status;
    private String locationNAME;

    public String getLocationNAME() {
        return locationNAME;
    }

    public void setLocationNAME(String locationNAME) {
        this.locationNAME = locationNAME;
    }

    public DepartmentResponseDto() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DepartmentResponseDto(long id, String name, Date createdOn, Date updatedOn, String status) {
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.status = status;
    }

}
