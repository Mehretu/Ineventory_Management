package ex.vvs.et.dto.Response;

import java.util.List;

public class ResourceListOutResourceDto {

    private List<ResourceResponseDto> resourceResponseDtos ;
    private Integer count;
    private StatusDto statusDto;

    public ResourceListOutResourceDto() {
    }

    public List<ResourceResponseDto> getResourceResponseDtos() {
        return resourceResponseDtos;
    }

    public void setResourceResponseDtos(List<ResourceResponseDto> resourceResponseDtos) {
        this.resourceResponseDtos = resourceResponseDtos;
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
