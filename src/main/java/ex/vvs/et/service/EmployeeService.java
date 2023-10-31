package ex.vvs.et.service;
import ex.vvs.et.dao.DepartmentsDao;
import ex.vvs.et.dao.EmployeeDao;
import ex.vvs.et.dto.Request.DateDto;
import ex.vvs.et.dto.Request.EmployeeRequestDto;
import ex.vvs.et.dto.Response.DepartmentResponseDto;
import ex.vvs.et.dto.Response.EmployeeResponseDto;
import ex.vvs.et.dto.Response.ResponseListOutEmployeeDto;
import ex.vvs.et.dto.Response.StatusDto;
import ex.vvs.et.model.Departments;
import ex.vvs.et.model.Employee;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Stateless
public class EmployeeService {
    @EJB
    private EmployeeDao employeeDao;
    @Inject
    DepartmentsDao departmentsDao;
    public StatusDto create(EmployeeRequestDto employeeRequestDto) {
        Departments departments = departmentsDao.findById(employeeRequestDto.getDepartmentId());
        Employee employee = new Employee();
        employee.setName(employeeRequestDto.getName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setStatus("available");
        employee.setDepartments(departments);

        employee.setCreatedOn(new Date());
        this.employeeDao.create(employee);

        return new StatusDto(true, "success");

    }
    public StatusDto update(EmployeeRequestDto employeeRequestDto){

        Employee employee = this.employeeDao.findById(employeeRequestDto.getId());
        if (employee == null) {
            return new StatusDto(false, "employee not found");

        }
        employee.setName(employeeRequestDto.getName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setStatus("available");
        employee.setUpdatedOn(new Date());
        this.employeeDao.update(employee);
        return new StatusDto(true, "success");
    }

    public StatusDto delete(EmployeeRequestDto employeeRequestDto) {
        Employee employee = this.employeeDao.findById(employeeRequestDto.getId());
        if (employee == null) {
            System.out.println("employee not found");

        }
        this.employeeDao.deleteById(employeeRequestDto.getId());
        return new StatusDto(true, "success");

    }
    public EmployeeResponseDto findById(long id){
        Employee employee = employeeDao.findById(id);
       // EmployeeRequestDto employeeRequestDto = new EmployeeRequestDto();
      //  Departments departments = departmentsDao.findById(employeeRequestDto.getDepartmentId());

        if(employee == null){
            System.out.println("employee not found");
        }
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setEmail(employee.getEmail());
        employeeResponseDto.setName(employee.getName());
        employeeResponseDto.setCreatedOn(employee.getCreatedOn());
        employeeResponseDto.setUpdatedOn(employee.getUpdatedOn());
        employeeResponseDto.setStatus(employee.getStatus());
      //  employee.setDepartments(departments);
        return employeeResponseDto;
    }

        public ResponseListOutEmployeeDto listAllEmployee(Integer start,Integer end){
        ResponseListOutEmployeeDto responseListOutEmployeeDto = new ResponseListOutEmployeeDto();
        List<EmployeeResponseDto>employeeArrayList = new ArrayList<>();
        List<Employee>employeeList = this.employeeDao.listAll(start,end);
        if (employeeList.size()== 0){
            responseListOutEmployeeDto.setCount(0);
            responseListOutEmployeeDto.setEmployeeResponseDtos(new ArrayList<>());
            responseListOutEmployeeDto.setStatusDto(new StatusDto(true,"empty list"));
            return responseListOutEmployeeDto;
        }
            employeeList.forEach(employee -> {
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            employeeResponseDto.setId(employee.getId());
            employeeResponseDto.setName(employee.getName());
            employeeResponseDto.setEmail(employee.getEmail());
            employeeResponseDto.setCreatedOn(employee.getCreatedOn());
            employeeResponseDto.setUpdatedOn(employee.getUpdatedOn());
            employeeResponseDto.setStatus(employee.getStatus());

            DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
            departmentResponseDto.setId(employee.getDepartments().getId());
            departmentResponseDto.setName(employee.getDepartments().getName());
            departmentResponseDto.setUpdatedOn(employee.getDepartments().getUpdatedOn());
            departmentResponseDto.setStatus(employee.getDepartments().getStatus());
            employeeResponseDto.setDepartmentResponseDto(departmentResponseDto);
            employeeArrayList.add(employeeResponseDto);
                }
        );
        responseListOutEmployeeDto.setCount(employeeList.size());
        responseListOutEmployeeDto.setStatusDto(new StatusDto(true,"successfull"));
        responseListOutEmployeeDto.setEmployeeResponseDtos(employeeArrayList);
        return responseListOutEmployeeDto;
    }



    public List<EmployeeResponseDto> listByEmployeeName(String name) {
        List<EmployeeResponseDto> employeenameArrayList = new ArrayList<>();
        List<Employee> employeeList = employeeDao.getByEmployeeData(name);

        if (employeeList != null) {

                employeeList.forEach(employee -> {
                EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
                employeeResponseDto.setId(employee.getId());
                employeeResponseDto.setName(employee.getName());
                employeeResponseDto.setCreatedOn(employee.getCreatedOn());
                employeeResponseDto.setUpdatedOn(employee.getUpdatedOn());
                employeeResponseDto.setStatus(employee.getStatus());
                DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
                departmentResponseDto.setId(employee.getDepartments().getId());
                departmentResponseDto.setName(employee.getDepartments().getName());
                departmentResponseDto.setUpdatedOn(employee.getDepartments().getUpdatedOn());
                departmentResponseDto.setStatus(employee.getDepartments().getStatus());
                employeeResponseDto.setDepartmentResponseDto(departmentResponseDto);
                employeenameArrayList.add(employeeResponseDto);
            });
        }
        return employeenameArrayList;
    }



public List<EmployeeResponseDto> listByEmployeeDate(DateDto dateDto){
        List<EmployeeResponseDto>employeeDateArrayList=new ArrayList<>();
        List<Employee>employeeList = employeeDao.getEmployeeByDate(dateDto.getStartDate(),dateDto.getEndDate());
        if (employeeList != null) {

            employeeList.forEach(employee -> {
            EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
            employeeResponseDto.setId(employee.getId());
            employeeResponseDto.setName(employee.getName());
            employeeResponseDto.setCreatedOn(employee.getCreatedOn());
            employeeResponseDto.setUpdatedOn(employee.getUpdatedOn());
            employeeResponseDto.setStatus(employee.getStatus());

            DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
            departmentResponseDto.setId(employee.getDepartments().getId());
            departmentResponseDto.setName(employee.getDepartments().getName());
            departmentResponseDto.setUpdatedOn(employee.getDepartments().getUpdatedOn());
            departmentResponseDto.setStatus(employee.getDepartments().getStatus());
            employeeResponseDto.setDepartmentResponseDto(departmentResponseDto);
            employeeDateArrayList.add(employeeResponseDto);
        });
    }
    return employeeDateArrayList;
}

}







