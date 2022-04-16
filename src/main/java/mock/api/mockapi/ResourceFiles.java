package mock.api.mockapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Configuration
public class ResourceFiles {

    @Value("classpath:error_response_body.json")
    private Resource errorResponseBody;

    @Value("classpath:success_response_body.json")
    private Resource successResponseBody;

    @Value("classpath:success_request_body.json")
    private Resource successRequestBody;

    @Bean(name = "errorResponseBody")
    public String errorResponseBody() {
        try (InputStream is = errorResponseBody.getInputStream()) {
            return StreamUtils.copyToString(is, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean(name = "successResponseBody")
    public String successResponseBody() {
        try (InputStream is = successResponseBody.getInputStream()) {
            return StreamUtils.copyToString(is, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean(name = "successRequestBody")
    public String successRequestBody() {
        try (InputStream is = successRequestBody.getInputStream()) {
            return StreamUtils.copyToString(is, StandardCharsets.ISO_8859_1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
