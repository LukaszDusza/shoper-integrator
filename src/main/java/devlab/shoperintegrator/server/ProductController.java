package devlab.shoperintegrator.server;


import devlab.shoperintegrator.model.products.Product;
import devlab.shoperintegrator.model.products.Products;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public Products getProducts(@RequestParam(value = "filters", required = false) String filterCriteria) {
            return productService.getProducts(filterCriteria);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public String insertProducts(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping("/products/{id}")
    public String updateProductById(@RequestBody Product product, @PathVariable String id) {
        return productService.updateProduct(product, id);
    }

    @PutMapping("/products/{code}/stock")
    public String updateProductByCodeOnlyStock(@RequestBody Product product, @PathVariable String code) {
        return productService.updateProduct(product, code);
    }

}
