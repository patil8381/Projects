import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.interfaces.managers.*;
import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.exceptions.*;
import java.util.*;

public class DesignationManagerGetDesignationByTitleTestCase
{
public static void main(String gg[])
{
DesignationInterface designation=new Designation();
String title=gg[0];
try
{
DesignationManagerInterface designationManager=DesignationManager.getDesignationManager();
designation=designationManager.getDesignationByTitle(title);
System.out.println("Designtion code : "+designation.getCode());
System.out.println("Designtion title : "+designation.getTitle());
}catch(BLException blException)
{
if(blException.hasGenericException())
{
System.out.println(blException.getGenericException());
}
List<String> properties=blException.getProperties();
for(String property:properties)
{
System.out.println(blException.getException(property));
}
}
}
}