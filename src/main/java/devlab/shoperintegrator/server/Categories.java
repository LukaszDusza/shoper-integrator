package devlab.shoperintegrator.server;

import lombok.Data;

import java.util.List;

@Data
public class Categories {
    private int count;
    private int pages;
    private int page;
    private List<String> list;


}
