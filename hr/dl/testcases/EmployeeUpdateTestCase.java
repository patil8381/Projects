import java.math.*;
import java.text.*;
import java.util.*;

import com.thinking.machines.enums.*;

import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.exceptions.*;

public class EmployeeUpdateTestCase
{
public static void main(String gg[])
{
try
{
String employeeId=gg[0];
String name=gg[1];
int designationCode=Integer.parseInt(gg[2]);
Date dateOfBirth=null;
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
try
{
dateOfBirth=sdf.parse(gg[3]);
}catch(ParseException pe)
{
System.out.println(pe.getMessage());
return;
}
char gender=gg[4].charAt(0);
boolean isIndian=Boolean.parseBoolean(gg[5]);
BigDecimal basicSalary=new BigDecimal(gg[6]);
String PANNumber=gg[7];
String aadharCardNumber=gg[8];

EmployeeDTOInterface employeeDTO=new EmployeeDTO();
EmployeeDAOInterface employeeDAO=new EmployeeDAO();
employeeDTO.setEmployeeId(employeeId);
employeeDTO.setName(name);
employeeDTO.setDesignationCode(designationCode);
employeeDTO.setDateOfBirth(dateOfBirth);

if(gender=='M')
{
employeeDTO.setGender(GENDER.MALE);
}
if(gender=='F')
{
employeeDTO.setGender(GENDER.FEMALE);
}

employeeDTO.setIsIndian(isIndian);
employeeDTO.setBasicSalary(basicSalary);
employeeDTO.setPANNumber(PANNumber);
employeeDTO.setAadharCardNumber(aadharCardNumber);

employeeDAO.update(employeeDTO);
System.out.println("Employee udpated with employee id : "+employeeDTO.getEmployeeId());
}
catch(DAOException d)
{
System.out.println(d.getMessage());
}
}
}