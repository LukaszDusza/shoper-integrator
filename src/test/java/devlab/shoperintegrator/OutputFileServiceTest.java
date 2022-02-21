package devlab.shoperintegrator;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import devlab.shoperintegrator.csv.CreatorCSV;
import devlab.shoperintegrator.wholesaler.BBTBMapper;
import devlab.shoperintegrator.wholesaler.MariniMapper;
import devlab.shoperintegrator.wholesaler.SuavinexMapper;
import devlab.shoperintegrator.wholesaler.TravelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest()
public class OutputFileServiceTest {

    @Autowired
    private BBTBMapper bbtbMapper;
    @Autowired
    private TravelMapper travelMapper;
    @Autowired
    private MariniMapper mariniMapper;
    @Autowired
    private SuavinexMapper suavinexMapper;

    @Test
    public void should_create_BBTB_CSV_file_from_path() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CreatorCSV.generateCSV("src/main/resources/templates/bbtb.xml", "src/main/resources/templates/", "bbtb_", bbtbMapper);
    }

    @Test
    public void should_create_BBTB_CSV_file_from_URL() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CreatorCSV.generateCSV("https://bbtb.pl/modules/pricewars2/service.php?id_xml=1", "src/main/resources/templates/", "bbtb_", bbtbMapper);
    }

    @Test
    public void should_create_Travel_CSV_file_from_path() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CreatorCSV.generateCSV("src/main/resources/templates/b2b_travel.xml", "src/main/resources/templates/", "travel_", travelMapper);
    }

    @Test
    public void should_create_Travel_CSV_file_from_URL() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CreatorCSV.generateCSV("https://whs.babyandtravel.pl/wm_state_bat_cst_b2b.xml", "src/main/resources/templates/", "travel_", travelMapper);
    }

    @Test
    public void should_create_Marini_CSV_file_from_URL() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CreatorCSV.generateCSV("https://marini.pl/b2b/marini-b2b.xml", "src/main/resources/templates/", "marini_", mariniMapper);
    }

    @Test
    public void should_create_Suavinex_CSV_file_from_URL() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CreatorCSV.generateCSV("https://suavinex.pl/produkty/sklepy-online,b8gdbt8jg4mge8nj", "src/main/resources/templates/", "suavinex_", suavinexMapper);
    }

}
