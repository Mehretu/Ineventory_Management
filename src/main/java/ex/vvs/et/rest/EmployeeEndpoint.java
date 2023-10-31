package ex.vvs.et.rest;

import ex.vvs.et.service.EmployeeService;
import io.swagger.annotations.Api;
import ex.vvs.et.dao.EmployeeDao;
import ex.vvs.et.dto.Request.DateDto;
import ex.vvs.et.dto.Request.EmployeeRequestDto;
import ex.vvs.et.dto.Response.EmployeeResponseDto;
import ex.vvs.et.dto.Response.ResponseListOutEmployeeDto;
import ex.vvs.et.dto.Response.StatusDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@Path("/employee")

@Api(value = "employee")
public class EmployeeEndpoint {
    @EJB
    private EmployeeService employeeService;
    @EJB
    private EmployeeDao employeeDao;
    @POST
    @Path("/createEmployee")

    public StatusDto create (EmployeeRequestDto employeeRequestDto){

        return employeeService.create(employeeRequestDto);


    }
    @POST
    @Path("/updateEmployee")

    public StatusDto update (EmployeeRequestDto employeeRequestDto){

        return employeeService.update(employeeRequestDto);


    }
    @POST
    @Path("/deleteEmployee")


    public StatusDto delete (EmployeeRequestDto employeeRequestDto){

        return employeeService.delete(employeeRequestDto);

    }
    @GET
    @Path("/findById")
        public EmployeeResponseDto findById(@QueryParam("id") int  id){
        return employeeService.findById(id);   }

    @GET
    @Path("/listAllEmployee")
        public ResponseListOutEmployeeDto listAllEmployee( @QueryParam("start")Integer start,@QueryParam("end") Integer end){
        return employeeService.listAllEmployee(start,end);
    }
    @GET
    @Path("/listByEmployeeName")
    public List<EmployeeResponseDto> listByEmployeeName(@QueryParam("employeeName") String name){
        return employeeService.listByEmployeeName(name);
    }


    @GET
    @Path("/listByEmployeeDate")
    public List<EmployeeResponseDto> listByEmployeeDate(DateDto dateDto){
        return employeeService.listByEmployeeDate(dateDto);
    }
}

