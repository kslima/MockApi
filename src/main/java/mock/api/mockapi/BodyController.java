package mock.api.mockapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/mockApi")
public class BodyController {

    private static final String PATH = "/token/validate";

    @Autowired
    private BodyService service;

    @PostMapping(value = PATH, produces="application/json")
    public ResponseEntity<String> post(@RequestBody String request) {
        String result = service.get(request);
        return ResponseEntity.ok().body(result);
    }
}
