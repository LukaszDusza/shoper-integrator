package devlab.shoperintegrator.model.products;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("pl_PL")
public class Locale{
    private String translation_id;
    private String product_id;
    private String name;
    private String short_description;
    private String description;
    private String active;
    private String lang_id;
    private String isdefault;
    private String seo_title;
    private String seo_description;
    private String seo_keywords;
    private String order;
    private String main_page;
    private String main_page_order;
    private String booster;
    private String seo_url;
    private String permalink;
    private String gfx_id;
}
