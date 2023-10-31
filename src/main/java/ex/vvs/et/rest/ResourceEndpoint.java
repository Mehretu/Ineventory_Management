package ex.vvs.et.rest;

import ex.vvs.et.service.ResourceService;
import io.swagger.annotations.Api;
import ex.vvs.et.dao.ResourcesDao;
import ex.vvs.et.dto.Request.ResourceRequestDto;
import ex.vvs.et.dto.Response.ResourceListOutResourceDto;
import ex.vvs.et.dto.Response.ResourceResponseDto;
import ex.vvs.et.dto.Response.StatusDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@Path("/resource")
@Api(value = "Resource")
public class ResourceEndpoint {
    @EJB
    private ResourceService resourceService;
    @EJB
    private ResourcesDao resourceDao;
    @POST
    @Path("/createresource")

    public StatusDto create (ResourceRequestDto resourceRequestDto){

        return resourceService.create(resourceRequestDto);


    }
    @POST
    @Path("/updateResource")

    public StatusDto update (ResourceRequestDto resourceRequestDto){

        return resourceService.update(resourceRequestDto);


    }

    @POST
    @Path("/deleteResource")
        public StatusDto delete (ResourceRequestDto resourceRequestDto){

        return resourceService.delete(resourceRequestDto);


    }
    @GET
    @Path("/findById")
    public ResourceResponseDto findById(@QueryParam("id") int  id){
        return resourceService.findById(id);   }



    @GET
    @Path("/listAllResource")
       public ResourceListOutResourceDto listAllResource(@QueryParam("start")Integer start, @QueryParam("end") Integer end){
        return resourceService.listAllResource(start,end);
    }
    @GET
    @Path("/listByResourceName")
    public List<ResourceResponseDto> listByResourceName(@QueryParam("resourceName") String name){
        return resourceService.listByResourceName(name);

    }
}

