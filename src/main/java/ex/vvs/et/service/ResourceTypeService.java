package ex.vvs.et.service;

import ex.vvs.et.dao.ResourceTypeDao;
import ex.vvs.et.dto.Request.ResourceTypeRequestDto;
import ex.vvs.et.dto.Response.ResourceTypeResponseDto;
import ex.vvs.et.dto.Response.StatusDto;
import ex.vvs.et.model.ResourceType;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Stateless
public class ResourceTypeService {

    @EJB
    private ResourceTypeDao resourceTypeDao;

    public StatusDto create(ResourceTypeRequestDto resourceTypeRequestDto) {
        ResourceType resourceType = new ResourceType();
        resourceType.setName(resourceTypeRequestDto.getName());
        resourceType.setCreatedOn(new Date());
        this.resourceTypeDao.create(resourceType);
        return new StatusDto(true, "success");


    }

    public StatusDto update(ResourceTypeRequestDto resourceTypeRequestDto) {
        ResourceType resourceType = this.resourceTypeDao.findById(resourceTypeRequestDto.getId());

        if (resourceType == null) {
            return new StatusDto(false, "resource type not found");
        }

        resourceType.setName(resourceTypeRequestDto.getName());

        resourceType.setUpdatedOn(new Date());
        this.resourceTypeDao.update(resourceType);
        return new StatusDto(true, "success"); }







    public StatusDto delete(ResourceTypeRequestDto resourceTypeRequestDto) {
        ResourceType resourceType = this.resourceTypeDao.findById(resourceTypeRequestDto.getId());
        if (resourceType == null){
            System.out.println("resource type not found");
        }
        this.resourceTypeDao.deleteById(resourceTypeRequestDto.getId());
        return new StatusDto(true,"success");
    }
    public ResourceTypeResponseDto findById(int id){
        ResourceType resourceType = resourceTypeDao.findById(id);
        if(resourceType == null){
            System.out.println("resources type no found");
        }
        ResourceTypeResponseDto resourceTypeResponseDto = new ResourceTypeResponseDto();
        resourceTypeResponseDto.setId(resourceType.getId());
        resourceTypeResponseDto.setName(resourceType.getName());
        resourceTypeResponseDto.setCreatedOn(resourceType.getCreatedOn());
        resourceTypeResponseDto.setCreatedOn(resourceType.getCreatedOn());
        resourceTypeResponseDto.setUpdatedOn(resourceType.getUpdatedOn());
        return resourceTypeResponseDto;
    }

    public List<ResourceTypeResponseDto> listAllResourceType(){

        List<ResourceTypeResponseDto>resourceTypeArrayList = new ArrayList<>();
        List<ResourceType> resourceTypeList= this.resourceTypeDao.listAll(null,null);
        resourceTypeList.forEach(resourceType ->{
            ResourceTypeResponseDto resourceTypeResponseDto = new ResourceTypeResponseDto();
            resourceTypeResponseDto.setId(resourceType.getId());
            resourceTypeResponseDto.setName(resourceType.getName());
            resourceTypeResponseDto.setCreatedOn(resourceType.getCreatedOn());
            resourceTypeResponseDto.setUpdatedOn(resourceType.getUpdatedOn());
                    resourceTypeArrayList.add(resourceTypeResponseDto);

                }
        );
        return resourceTypeArrayList;


    }


    public List<ResourceTypeResponseDto> listByResourceTypeName(String name) {

        List<ResourceTypeResponseDto> resourceTypenameArrayList = new ArrayList<>();
        List<ResourceType> resourceList = resourceTypeDao.getByResourceTypeData(name);
        if (resourceList != null) {
            resourceList.forEach(resourceType -> {
                ResourceTypeResponseDto resourceTypeResponseDto = new ResourceTypeResponseDto();

                resourceTypeResponseDto.setId(resourceType.getId());

                resourceTypeResponseDto.setName(resourceType.getName());
                resourceTypeResponseDto.setCreatedOn(resourceType.getCreatedOn());
                resourceTypeResponseDto.setUpdatedOn(resourceType.getUpdatedOn());
                resourceTypenameArrayList.add(resourceTypeResponseDto);

            });
        }
        return resourceTypenameArrayList;
    }

}


