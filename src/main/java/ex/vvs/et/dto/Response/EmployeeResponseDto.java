package ex.vvs.et.dto.Response;

import java.util.Date;

    public class EmployeeResponseDto {

        private long id;
        private String name;
        private Date createdOn;
        private Date updatedOn;
        private String status;
        private String email;

        private DepartmentResponseDto departmentResponseDto;
        public EmployeeResponseDto() {
        }

        public EmployeeResponseDto(long id, String name, Date createdOn, Date updatedOn, String status, String email, DepartmentResponseDto departmentResponseDto) {
            this.id = id;
            this.name = name;
            this.createdOn = createdOn;
            this.updatedOn = updatedOn;
            this.status = status;
            this.email = email;
            this.departmentResponseDto = departmentResponseDto;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public DepartmentResponseDto getDepartmentResponseDto() {
            return departmentResponseDto;
        }

        public void setDepartmentResponseDto(DepartmentResponseDto departmentResponseDto) {
            this.departmentResponseDto = departmentResponseDto;
        }
    }


