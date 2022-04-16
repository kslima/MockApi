package mock.api.mockapi;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class BodyService {

    private static final String SUCCESS_RESPONSE_JSON_FILE_PATH = "success_response_body.json";
    private static final String ERROR_RESPONSE_JSON_FILE_PATH = "error_response_body.json";
    private static final String SUCCESS_REQUEST_JSON_FILE_PATH = "success_request_body.json";

    @Transactional(readOnly = true)
    public String get(String request) {
        request = removeWhiteSpaceAndLineBreak(request);
        String successRequest = removeWhiteSpaceAndLineBreak(getJsonFileContent(SUCCESS_REQUEST_JSON_FILE_PATH));
        if (request.equals(successRequest)) {
            return getJsonFileContent(SUCCESS_RESPONSE_JSON_FILE_PATH);
        }
        return getJsonFileContent(ERROR_RESPONSE_JSON_FILE_PATH);
    }

    public static String getJsonFileContent(String path) {
        try {
            File resource = new ClassPathResource(path).getFile();
            return new String(Files.readAllBytes(resource.toPath()));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static String removeWhiteSpaceAndLineBreak(String str) {
        String result = str.replaceAll("[\r\n]", "")
                .replaceAll(" ", "")
                .replaceAll("\\\\n|\\\\r", "");

        return result.replaceAll(System.getProperty("line.separator"), "");
    }

}
