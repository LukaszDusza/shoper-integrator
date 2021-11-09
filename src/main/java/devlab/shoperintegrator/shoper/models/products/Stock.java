package devlab.shoperintegrator.shoper.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("stock")
public class Stock{
    private String stock_id;
    private String extended;
    private String price;
    private String price_type;
    private String price_buying;
    private String stock;
    @JsonProperty("package")
    private String package_;
    private String warn_level;
    private String sold;
    private String weight;
    private String weight_type;
    private String active;
    private String product_id;
    private Object availability_id;
    @JsonProperty("default")
    private String default_;
    private String delivery_id;
    private Object gfx_id;
    private String code;
    private String ean;
    private String comp_weight;
    private String comp_price;
    private String comp_promo_price;
    private String price_wholesale;
    private String comp_price_wholesale;
    private String comp_promo_price_wholesale;
    private String price_special;
    private String comp_price_special;
    private String comp_promo_price_special;
    private String price_type_wholesale;
    private String price_type_special;
    private Object calculation_unit_id;
    private String calculation_unit_ratio;
}
