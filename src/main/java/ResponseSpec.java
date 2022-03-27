import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
    public ResponseSpecification getResponseSpec()
    {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        ResponseSpecification responseSpecification = responseSpecBuilder.build();
        return responseSpecification;
    }
}
