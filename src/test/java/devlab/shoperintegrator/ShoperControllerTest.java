package devlab.shoperintegrator;


import devlab.shoperintegrator.server.ShoperController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class ShoperControllerTest {

    @Autowired
    private ShoperController shoperController;
    private String token;

    private void getAuthTokenModel() {
        token = shoperController.getAuthToken();

    }

    @Test
    void getTokenShouldReturnValidTokenStringSize() {
        getAuthTokenModel();
        assertThat(token).hasSize(40); //default token size
    }

    @Test
    void getTokenFromSystemPropertyShouldReturnNotBlankString() {
        getAuthTokenModel();
        assertThat(System.getProperty("token")).isNotBlank();
    }
}
