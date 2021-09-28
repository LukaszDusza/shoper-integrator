package devlab.shoperintegrator;


import devlab.shoperintegrator.model.products.Product;
import devlab.shoperintegrator.model.products.Products;
import devlab.shoperintegrator.server.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Test
    void getTokenFromSystemPropertyShouldReturnNotBlankString() {
        assertThat(System.getProperty("token")).isNotBlank();
    }

    @Test
    void getProductsShouldBeNotNull() {
        Products products = productController.getProducts("{\"stock.code\":{\"=\":\"KX6358_1\"}}");
        assertThat(products).isNotNull();
    }

    @Test
    void getProductByIdShouldBeNotNull() {
        Product product = productController.getProductById("117");
        assertThat(product).isNotNull();
    }
}
