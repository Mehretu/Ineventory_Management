package ex.vvs.et.dto.Request;

import java.util.Date;

public class EmployeeRequestDto {
    private Long id;
    private String name;
    private String email;
    private Integer departmentId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmployeeRequestDto() {
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public EmployeeRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
