package devlab.shoperintegrator.shoper.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("translations")
public class Translations{
    @JsonProperty("pl_PL")
    private Locale locale;
}