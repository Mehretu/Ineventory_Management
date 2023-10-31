package ex.vvs.et.service;
import ex.vvs.et.dto.Response.ResourceListOutResourceDto;
import ex.vvs.et.dto.Response.ResourceResponseDto;
import ex.vvs.et.dto.Response.ResourceTypeResponseDto;
import ex.vvs.et.dto.Response.StatusDto;
import ex.vvs.et.dao.ResourceTypeDao;
import ex.vvs.et.dao.ResourcesDao;

import ex.vvs.et.dto.Request.ResourceRequestDto;
import org.act.com.dto.Response.*;

import ex.vvs.et.model.ResourceType;
import ex.vvs.et.model.Resources;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Stateless
public class ResourceService {
    @EJB
    private ResourcesDao resourcesDao;


    @Inject
    ResourceTypeDao resourceTypeDao;

    public StatusDto create(ResourceRequestDto resourceRequestDto) {
        ResourceType resourceType = resourceTypeDao.findById(resourceRequestDto.getResourceTypeId());

        if (resourceType == null) {
            return new StatusDto(false, "there is not resourceType by this id " + resourceRequestDto.getResourceTypeId());
        }

        Resources resources = new Resources();
        resources.setName(resourceRequestDto.getName());
        resources.setDescription(resourceRequestDto.getDescription());
        resources.setResourceType(resourceType);
        resources.setStatus("available");
        resources.setCreatedOn(new Date());
        this.resourcesDao.create(resources);
        return new StatusDto(true, "success");


    }

    public StatusDto update(ResourceRequestDto resourceRequestDto) {
        Resources resources = this.resourcesDao.findById(resourceRequestDto.getId());
        if (resources == null) {
            return new StatusDto(false, "resource not found");
        }

        resources.setName(resourceRequestDto.getName());
        resources.setDescription(resourceRequestDto.getDescription());

        resources.setStatus("available");
        resources.setUpdatedOn(new Date());
        this.resourcesDao.update(resources);
        return new StatusDto(true, "success");
    }

    public StatusDto delete(ResourceRequestDto resourceRequestDto) {
        Resources resource = this.resourcesDao.findById(resourceRequestDto.getId());
        if (resource == null) {
            System.out.println("resource not found");
        }
        this.resourcesDao.deleteById(resourceRequestDto.getId());
        return new StatusDto(true, "success");
    }


    public ResourceResponseDto findById(long id) {
        Resources resources = resourcesDao.findById(id);
        if (resources == null) {
            System.out.println("resources no found");
        }


        ResourceResponseDto resourceResponseDto = new ResourceResponseDto();
        resourceResponseDto.setId(resources.getId());
        resourceResponseDto.setName(resources.getName());
        resourceResponseDto.setDescription(resources.getDescription());
        resourceResponseDto.setCreatedOn(resources.getCreatedOn());
        resourceResponseDto.setStatus(resources.getStatus());
        resourceResponseDto.setUpdatedOn(resources.getUpdatedOn());
        return resourceResponseDto;
    }



    public ResourceListOutResourceDto listAllResource(Integer start , Integer end) {
        ResourceListOutResourceDto resourceListOutResourceDto = new ResourceListOutResourceDto();
        List<ResourceResponseDto> resourceArrayList = new ArrayList<>();
        List<Resources> resourceList = this.resourcesDao.listAll(start, end);

        if (resourceList.size() == 0) {
            resourceListOutResourceDto.setCount(0);
            resourceListOutResourceDto.setResourceResponseDtos(new ArrayList<>());
            resourceListOutResourceDto.setStatusDto(new StatusDto(true, "empty list"));
            return resourceListOutResourceDto;
        }
        resourceList.forEach(resource -> {
            ResourceResponseDto resourceResponseDto = new ResourceResponseDto();
            // resourceArrayList.setId(resource.getId());
                    resourceResponseDto.setName(resource.getName());
            resourceResponseDto.setCreatedOn(resource.getCreatedOn());
            resourceResponseDto.setUpdatedOn(resource.getUpdatedOn());

            ResourceTypeResponseDto resourceTypeResponseDto = new ResourceTypeResponseDto();
            resourceTypeResponseDto.setId(resource.getResourceType().getId());
            resourceTypeResponseDto.setName(resource.getResourceType().getName());
            resourceTypeResponseDto.setUpdatedOn(resource.getResourceType().getUpdatedOn());
            resourceResponseDto.setResourceTypeResponseDto(resourceTypeResponseDto);

            resourceArrayList.add(resourceResponseDto);
                }
        );
        resourceListOutResourceDto.setCount(resourceList.size());
        resourceListOutResourceDto.setStatusDto(new StatusDto(true, "successfull"));
        resourceListOutResourceDto.setResourceResponseDtos(resourceArrayList);
        return resourceListOutResourceDto;

    }
    public List<ResourceResponseDto> listByResourceName(String name) {

        List<ResourceResponseDto> resourcenameArrayList = new ArrayList<>();
        List<Resources> resourceList = resourcesDao.getByResourceData(name);
        if (resourceList != null) {
            resourceList.forEach(resource -> {
                ResourceResponseDto resourceResponseDto = new ResourceResponseDto();
                resourceResponseDto.setId(resource.getId());
                resourceResponseDto.setResourceType(resource.getResourceType());
                resourceResponseDto.setName(resource.getName());
                resourceResponseDto.setCreatedOn(resource.getCreatedOn());
                resourceResponseDto.setUpdatedOn(resource.getUpdatedOn());
                resourceResponseDto.setStatus(resource.getStatus());
                resourcenameArrayList.add(resourceResponseDto);

            });
        }
        return resourcenameArrayList;
    }



}





