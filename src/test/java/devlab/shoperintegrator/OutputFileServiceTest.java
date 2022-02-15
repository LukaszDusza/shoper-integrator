package devlab.shoperintegrator;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import devlab.shoperintegrator.b2bTravel.B2BTravelMapper;
import devlab.shoperintegrator.b2bTravel.B2BTravelService;
import devlab.shoperintegrator.bbtb.BBTBService;
import devlab.shoperintegrator.utils.csv.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;

@SpringBootTest()
public class OutputFileServiceTest {

    @Autowired
    private BBTBService bbtbService;

    @Autowired
    private B2BTravelService b2BTravelService;

    //bbtb
    @Test
    public void should_download_BBTB_XML_file() throws IOException {
        FileUtils.downloadFile("https://bbtb.pl/modules/pricewars2/service.php?id_xml=1", "src/main/resources/templates/", "bbtb_");
    }

    @Test
    public void should_create_BBTB_csv_file_from_path() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        bbtbService.generateCSV("src/main/resources/templates/bbtb.xml", "src/main/resources/templates/");
    }

    @Test
    public void should_create_BBTB_csv_file_from_URL() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        bbtbService.generateCSV("https://bbtb.pl/modules/pricewars2/service.php?id_xml=1", "src/main/resources/templates/");
    }

    //b2b_travel
    @Test
    public void should_download_B2B_Travel_XML_file() throws IOException {
        FileUtils.downloadFile("https://whs.babyandtravel.pl/wm_state_bat_cst_b2b.xml", "src/main/resources/templates/", "travel_");
    }

    @Test
    public void should_create_B2B_Travel_csv_file_from_path() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        b2BTravelService.generateCSV("src/main/resources/templates/b2b_travel.xml", "src/main/resources/templates/");
    }

    @Test
    public void should_create_B2B_Travel_csv_file_from_URL() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        b2BTravelService.generateCSV("https://whs.babyandtravel.pl/wm_state_bat_cst_b2b.xml", "src/main/resources/templates/");
    }

}
