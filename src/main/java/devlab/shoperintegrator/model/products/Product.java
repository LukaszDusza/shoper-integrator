package devlab.shoperintegrator.model.products;

import com.google.gson.Gson;
import lombok.Data;

import java.util.List;

@Data
public class Product {
    private String product_id;
    private String producer_id;
    private Object group_id;
    private String tax_id;
    private String add_date;
    private String edit_date;
    private String other_price;
    private String pkwiu;
    private String unit_id;
    private String in_loyalty;
    private Object loyalty_score;
    private Object loyalty_price;
    private String bestseller;
    private String newproduct;
    private String dimension_w;
    private String dimension_h;
    private String dimension_l;
    private String vol_weight;
    private Object currency_id;
    private Object gauge_id;
    private String unit_price_calculation;
    private String type;
    private int category_id;
    private List<Integer> categories;
    private List<Object> collections;
    private Object promo_price;
    private String code;
    private String ean;
    private Stock stock;
    private Translations translations;
    private List<Object> options;
    private List<Object> attributes;
    private List<Object> related;
    private MainImage main_image;
    private boolean is_product_of_day;
    private List<Object> feeds_excludes;
    private List<Object> tags;

    public String toString() {
        return new Gson().toJson(this);
    }
}
