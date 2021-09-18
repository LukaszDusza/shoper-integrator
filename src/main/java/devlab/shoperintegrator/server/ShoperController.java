package devlab.shoperintegrator.server;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ShoperController {

    private final ShoperService shoperService;

    public ShoperController(ShoperService shoperService) {
        this.shoperService = shoperService;
    }

    @GetMapping("/token")
    public String getAuthToken() {
        return shoperService.getAuthToken().getAccessToken();
    }

    @GetMapping("/categories")
    public Categories getCategories() {
        return shoperService.getCategories();
    }

}
