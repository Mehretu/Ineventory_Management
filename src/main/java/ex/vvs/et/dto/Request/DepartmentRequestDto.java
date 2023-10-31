package ex.vvs.et.dto.Request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DepartmentRequestDto {

    private Long id;
    private String name;
private  String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DepartmentRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public DepartmentRequestDto(String name) {
        this.name = name;
    }
    public String getName() {
        return name;

    }




}
