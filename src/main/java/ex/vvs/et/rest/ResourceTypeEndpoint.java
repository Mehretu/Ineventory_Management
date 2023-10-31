package ex.vvs.et.rest;

import ex.vvs.et.dto.Response.StatusDto;
import ex.vvs.et.service.ResourceTypeService;
import io.swagger.annotations.Api;
import ex.vvs.et.dao.ResourceTypeDao;
import ex.vvs.et.dto.Request.ResourceTypeRequestDto;
import ex.vvs.et.dto.Response.ResourceTypeResponseDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@Path("/resourceType")
@Api(value = "resourceType")
public class ResourceTypeEndpoint {
    @EJB
    private ResourceTypeService resourceTypeService;
    @EJB
    private ResourceTypeDao resourceTypeDao;
    @POST
    @Path("/createresourceType")

    public StatusDto create (ResourceTypeRequestDto resourceTypeRequestDto){

        return resourceTypeService.create(resourceTypeRequestDto);


    }
    @POST
    @Path("/updateResourceType")

    public StatusDto update (ResourceTypeRequestDto resourceTypeRequestDto){

        return resourceTypeService.update(resourceTypeRequestDto);


    }

    @POST
    @Path("/deleteResourceType")

    public StatusDto delete (ResourceTypeRequestDto resourceTypeRequestDto){

        return resourceTypeService.delete(resourceTypeRequestDto);


    }
    @GET
    @Path("/findById")
    public ResourceTypeResponseDto findById(@QueryParam("id") int  id){
        return resourceTypeService.findById(id);   }

    @GET
    @Path("/listAllResourceType")

    public List<ResourceTypeResponseDto> listAllResourceType(){
        return resourceTypeService.listAllResourceType();
    }
    @GET
    @Path("/listByResourceTypeName")
    public List<ResourceTypeResponseDto> listByResourceTypeName(@QueryParam("resourceTypeName") String name){
        return resourceTypeService.listByResourceTypeName(name);

    }
}

