import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
public class HttpInvoker {
    protected Response callWithLog(Method httpMethod, String path, RequestSpecification requestSpecification,
                                   ResponseSpecification responseSpecification) {
        return invoke(httpMethod, path, requestSpecification).then().log().all().spec(responseSpecification).extract()
                .response();
    }

    protected Response callWithoutLog(Method httpMethod, String path, RequestSpecification requestSpecification,
                                      ResponseSpecification responseSpecification) {
        return invoke(httpMethod, path, requestSpecification).then().log().ifError().spec(responseSpecification)
                .extract().response();
    }

    public Response invoke(Method httpMethod, String path, RequestSpecification requestSpecification) {
        switch (httpMethod) {
            case POST:
                return RestAssured.given(requestSpecification).when().post(path);
            case PUT:
                return RestAssured.given(requestSpecification).when().put(path);
            case GET:
                return RestAssured.given(requestSpecification).when().get(path);
            case DELETE:
                return RestAssured.given(requestSpecification).when().delete(path);
            case PATCH:
                return RestAssured.given(requestSpecification).when().patch(path);
            default:
                throw new RuntimeException("Invalid / not supported request type: " + httpMethod);
        }
    }
}
