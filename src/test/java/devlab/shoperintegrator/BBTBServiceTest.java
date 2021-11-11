package devlab.shoperintegrator;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import devlab.shoperintegrator.bbtb.BBTBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest()
public class BBTBServiceTest {

    @Autowired
    private BBTBService bbtbService;

    @Test
    public void should_create_csv_file() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        bbtbService.generateCSV();
    }

}
