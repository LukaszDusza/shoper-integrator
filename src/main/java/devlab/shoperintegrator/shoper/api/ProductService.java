package devlab.shoperintegrator.shoper.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import devlab.shoperintegrator.shoper.models.products.Product;
import devlab.shoperintegrator.shoper.models.products.Products;
import devlab.shoperintegrator.utils.EnvironmentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final HttpWrapper<Product> httpWrapper;
    private final ObjectMapper objectMapper;
    private final HttpHeaders headers;
    private static final String API_PRODUCTS = "https://malinakids.pl/webapi/rest/products/";

    public ProductService(HttpWrapper<Product> httpWrapper) {
        this.httpWrapper = httpWrapper;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.headers = new HttpHeaders();
        setAuthorizationHeader();
    }

    Products getProducts(String filterCriteria) {
        var url = API_PRODUCTS;
        if(filterCriteria != null) {
            url += "?filters=" + filterCriteria;
        }
        ResponseEntity<String> response = httpWrapper.performGETRequest(url, headers);
        if(response.getStatusCode().is5xxServerError()) {
            logger.error("Getting error from response: {}", response);
            throw new HttpClientErrorException(response.getStatusCode());
        }
        Products products;
        try {
            products = objectMapper.readValue(response.getBody(), Products.class);
        } catch (JsonProcessingException e) {
            logger.error("cannot deserialize responseBody: {}", e.getMessage());
            return null;
        }
        return products;
    }

    Product getProductById(String id) {
        ResponseEntity<String> response = httpWrapper.performGETRequest(API_PRODUCTS + "/" + id, headers);
        Product product;
        try {
            product = objectMapper.readValue(response.getBody(), Product.class);
        } catch (JsonProcessingException e) {
            logger.error("cannot deserialize responseBody: {}", e.getMessage());
            return null;
        }
        logger.info("Product: {}", product);
        return product;
    }

    public String insertProduct(Product product) {
        //todo skonczyc metode instert na wzor update
        String responseBody = httpWrapper.performPOSTRequest(API_PRODUCTS, headers, product);
        return responseBody;

    }

    public String updateProduct(Product product, String id) {
        String status = httpWrapper.performPUTRequest(API_PRODUCTS + "/" + id, headers, product);
        String productUpdate = product.getProduct_id() + " " +  product.getTranslations().getLocale().getName();
        if ("1".equals(status)) {
            logger.info("Product has updated: {}", productUpdate);
        } else {
            logger.error("Cannot update product: {}", productUpdate);
        }
        return status;
    }

    public String updateProductOnlyStock(Product product, String id) {
        String status = httpWrapper.performPUTRequest(API_PRODUCTS + "/" + id, headers, product);
        String productToUpd = product.getProduct_id() + " " +  product.getTranslations().getLocale().getName();
        if ("1".equals(status)) {
            logger.info("Product has updated: {}", productToUpd);
        } else {
            logger.error("Cannot update product: {}", productToUpd);
        }
        return status;
    }



    private void setAuthorizationHeader() {
        //todo dodac obsluge expired date tokena jako drugi warunek if
        if (headers.containsKey("Authorization")) {
            return;
        }
        String token = EnvironmentUtils.getProperty("token");
        if (token == null) {
            token = httpWrapper.getAccessToken();
            logger.debug("getting new access token: {}", token);
        }
        headers.add("Authorization", "Bearer " + token);
        logger.debug("adding header: {}", headers.get("Authorization"));
    }
}
