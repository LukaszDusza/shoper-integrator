package devlab.shoperintegrator.shoper.models.products;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("main_image")
public class MainImage{
    private String gfx_id;
    private String name;
    private String unic_name;
    private String order;
    private String hidden;
    private Translations translations;
    private String extension;
}
