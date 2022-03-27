import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public RequestSpecification getRequestSpec(String contentType, String baseUri) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder()
                .setConfig(RestAssuredConfig.config().encoderConfig(
                        EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .setBaseUri(baseUri).log(LogDetail.URI).log(LogDetail.BODY).log(LogDetail.HEADERS)
                .log(LogDetail.METHOD);

        if (contentType != null) {
            specBuilder.setContentType(contentType);
        }

        return specBuilder.build();
    }
}
