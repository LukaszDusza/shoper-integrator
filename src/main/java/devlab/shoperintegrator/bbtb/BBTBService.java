package devlab.shoperintegrator.bbtb;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import devlab.shoperintegrator.utils.CSVBuilder;
import devlab.shoperintegrator.utils.ParserXML;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.List;

@Service
public class BBTBService {
    Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${bbtb.download.path}")
    private String fileURL;

    private String downloadAndSaveFile() throws IOException {
        String fileName = System.currentTimeMillis() + ".xml";
        File file = new File(fileName);
        FileUtils.copyURLToFile(new URL(fileURL), file);
        return file.getAbsolutePath();
    }

    public void generateCSV(String filePath, String outPath) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        generateCSVInternal(filePath, outPath);
    }

    public void generateCSV() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        generateCSVInternal(null, null);
    }

    private void generateCSVInternal(String filePath, String outPath) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        if (StringUtils.isBlank(filePath)) {
            filePath = downloadAndSaveFile();
        }
        String fileName = "bbtb_" + System.currentTimeMillis() + ".csv";
        if (StringUtils.isBlank(outPath)) {
            outPath = "/Users/lukasz/projects/shoper-integrator/src/main/resources/templates/" + fileName;
        } else {
            outPath = outPath + fileName;
        }
        BBTBMapper mapper = new BBTBMapper();
        ParserXML.parseFile(filePath, mapper);
        List<BBTB> series = mapper.getObjects();
        CSVBuilder<BBTB> builder = new CSVBuilder<>();
        builder.writeCsv(outPath, series, BBTB.class, (char) 59);
    }

}
