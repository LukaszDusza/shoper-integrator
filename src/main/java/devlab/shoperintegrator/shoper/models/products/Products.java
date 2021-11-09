package devlab.shoperintegrator.shoper.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Products {
    private String count;
    private int pages;
    private int page;
    @JsonProperty("list")
    private List<Product> products;


}
