import com.google.gson.Gson;
import com.tbsq.api.automation.dto.CompanyDetail;
import com.tbsq.api.automation.dto.EmployeeDetail;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class APITest {
    String baseUrl="https://qvl7e.mocklab.io/tabsquare/employee/details";
    RequestSpec requestSpec=new RequestSpec();
    HttpInvoker httpInvoker=new HttpInvoker();
    ResponseSpec responseSpec=new ResponseSpec();

    @Test
    public void employeeDetailsTest()
    {
        Response response=httpInvoker.callWithLog(Method.GET,baseUrl,requestSpec.getRequestSpec("application/json",baseUrl),responseSpec.getResponseSpec());
        Gson gson = new Gson();
        CompanyDetail companyDetail=gson.fromJson(response.asString(),CompanyDetail.class);
        System.out.println(companyDetail.getAddress());
        List<EmployeeDetail> employeeDetail=companyDetail.getEmployeeDetails();
        employeeDetail.stream().forEach(ed -> System.out.println(ed.getFirstName()+" "+ed.getLastName()+" "+ed.getDOB()));
    }
}
