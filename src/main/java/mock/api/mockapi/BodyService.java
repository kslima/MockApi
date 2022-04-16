package mock.api.mockapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BodyService {

    @Autowired
    @Qualifier("errorResponseBody")
    private String  errorResponseBody;

    @Autowired
    @Qualifier("successResponseBody")
    private String  successResponseBody;

    @Autowired
    @Qualifier("successRequestBody")
    private String  successRequestBody;

    @Transactional(readOnly = true)
    public String get(String request) {
        request = removeWhiteSpaceAndLineBreak(request);
        String successRequest = removeWhiteSpaceAndLineBreak(successRequestBody);
        if (request.equals(successRequest)) {
            return successResponseBody;
        }
        return errorResponseBody;
    }

    public static String removeWhiteSpaceAndLineBreak(String str) {
        String result = str.replaceAll("[\r\n]", "")
                .replaceAll(" ", "")
                .replaceAll("\\\\n|\\\\r", "");

        return result.replaceAll(System.getProperty("line.separator"), "");
    }

}
