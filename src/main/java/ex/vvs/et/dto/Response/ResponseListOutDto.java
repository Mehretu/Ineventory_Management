package ex.vvs.et.dto.Response;

import java.util.List;

public class ResponseListOutDto {

   private List<DepartmentResponseDto> departmentResponseDtoList ;
   private Integer count;
   private StatusDto statusDto;

    public ResponseListOutDto() {

    }

    public List<DepartmentResponseDto> getDepartmentResponseDtoList() {
        return departmentResponseDtoList;
    }

    public void setDepartmentResponseDtoList(List<DepartmentResponseDto> departmentResponseDtoList) {
        this.departmentResponseDtoList = departmentResponseDtoList;
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
