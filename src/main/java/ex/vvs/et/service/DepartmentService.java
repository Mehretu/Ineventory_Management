package ex.vvs.et.service;
import ex.vvs.et.dao.DepartmentsDao;
import ex.vvs.et.dto.Request.DepartmentRequestDto;
import ex.vvs.et.dto.Response.DepartmentResponseDto;
import ex.vvs.et.dto.Response.ResponseListOutDto;
import ex.vvs.et.dto.Response.StatusDto;
import ex.vvs.et.model.Departments;
import sun.jvm.hotspot.tools.soql.SOQL;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Stateless
public class DepartmentService {
    @EJB
    private DepartmentsDao departmentsDao;
    public StatusDto create(DepartmentRequestDto departmentRequestDto) {
        Departments departments = new Departments();
        departments.setName(departmentRequestDto.getName());
        departments.setStatus(departmentRequestDto.getStatus());
        departments.setCreatedOn(new Date());
        this.departmentsDao.create(departments);
        return new StatusDto(true, "success");
    }
    public StatusDto update(DepartmentRequestDto departmentRequestDto) {
        Departments departments = this.departmentsDao.findById(departmentRequestDto.getId());
        if (departments == null) {
            return new StatusDto(false, "departments not found");
        }
        departments.setName(departmentRequestDto.getName());
        departments.setStatus("available");
        departments.setUpdatedOn(new Date());
        this.departmentsDao.update(departments);
        return new StatusDto(true, "success");
    }
    public StatusDto delete(DepartmentRequestDto departmentRequestDto) {
        Departments departments = this.departmentsDao.findById(departmentRequestDto.getId());
        if (departments == null){
            System.out.println("department not found");
        }
        this.departmentsDao.deleteById(departmentRequestDto.getId());
        return new StatusDto(true,"success");
    }
    public DepartmentResponseDto findById(long id){
        Departments departments = departmentsDao.findById(id);
        if(departments == null){
            System.out.println("department no found");
    }
    DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
    departmentResponseDto.setId(departments.getId());
    departmentResponseDto.setName(departments.getName());
    departmentResponseDto.setCreatedOn(departments.getCreatedOn());
    departmentResponseDto.setCreatedOn(departments.getCreatedOn());
    departmentResponseDto.setStatus(departments.getStatus());
    departmentResponseDto.setUpdatedOn(departments.getUpdatedOn());
    return departmentResponseDto;
}

public ResponseListOutDto listAllDepartment(Integer start,Integer maximum){
        ResponseListOutDto responseListOutDto = new ResponseListOutDto();
        List<DepartmentResponseDto>departmentArrayList = new ArrayList<>();
        List<Departments> departmentsList = this.departmentsDao.listAll(start,maximum);

        if(departmentsList.size()==0){
            responseListOutDto.setCount(0);
            responseListOutDto.setDepartmentResponseDtoList(new ArrayList<>());
            responseListOutDto.setStatusDto(new StatusDto(false,"empty list"));
        return responseListOutDto;
        }
            departmentsList.forEach(department ->{
            DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
            String locationName = locationName(department.getLatLong());
            departmentResponseDto.setLocationNAME(locationName);
        departmentResponseDto.setId(department.getId());
        departmentResponseDto.setName(department.getName());
        departmentResponseDto.setCreatedOn(department.getCreatedOn());
        departmentResponseDto.setUpdatedOn(department.getUpdatedOn());
        departmentResponseDto.setStatus(department.getStatus());
        departmentArrayList.add(departmentResponseDto);

        } );

    responseListOutDto.setCount(departmentsList.size());
    responseListOutDto.setDepartmentResponseDtoList(departmentArrayList);
    responseListOutDto.setStatusDto(new StatusDto(true,"successfull"));
return responseListOutDto;
//        return departmentArrayList;
}

public String locationName(String latitudeLongtitude){
       //get api name
    return "addis ababa";
}
    public List<DepartmentResponseDto> listByNameDepartment(String name) {

        List<DepartmentResponseDto> departmentNameArrayList = new ArrayList<>();
        List<Departments> departmentsList = departmentsDao.getByDepartmentName(name);
        if (departmentsList != null) {
            departmentsList.forEach(department -> {
                DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
                departmentResponseDto.setId(department.getId());
                departmentResponseDto.setName(department.getName());
                departmentResponseDto.setCreatedOn(department.getCreatedOn());
                departmentResponseDto.setUpdatedOn(department.getUpdatedOn());
                departmentResponseDto.setStatus(department.getStatus());
                departmentNameArrayList.add(departmentResponseDto);
            });

        }
            return departmentNameArrayList;
        }



    }