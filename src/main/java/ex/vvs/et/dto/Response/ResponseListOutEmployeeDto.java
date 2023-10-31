package ex.vvs.et.dto.Response;

import java.util.List;

public class ResponseListOutEmployeeDto {

   private List<EmployeeResponseDto> employeeResponseDtos ;
   private Integer count;
   private StatusDto statusDto;

    public ResponseListOutEmployeeDto() {
    }

    public List<EmployeeResponseDto> getEmployeeResponseDtos() {
        return employeeResponseDtos;
    }

    public void setEmployeeResponseDtos(List<EmployeeResponseDto> employeeResponseDtos) {
        this.employeeResponseDtos = employeeResponseDtos;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public StatusDto getStatusDto() {
        return statusDto;
    }

    public void setStatusDto(StatusDto statusDto) {
        this.statusDto = statusDto;
    }
}
