package devlab.shoperintegrator.bbtb;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import devlab.shoperintegrator.utils.CSVBuilder;
import org.apache.commons.io.FileUtils;
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
    private String bbtbDownloadPath;

    @Value("${csv.write.file.path}")
    private String csvWriteFilePath;

    public String downloadFile() throws IOException {
        String fileName = System.currentTimeMillis() + ".xml";
        File file = new File(fileName);
        FileUtils.copyURLToFile(new URL(bbtbDownloadPath), file);
        return file.getAbsolutePath();
    }

    public String getLocalFile() {
        File file = FileUtils.getFile(bbtbDownloadPath);
        return file.getAbsolutePath();
    }

    public void generateCSVFile() throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        String file = downloadFile();
//        String file = getLocalFile();
        BBTBParserXML.parseFile(file);
        List<BBTB> series = BBTBParserXML.handler.getObjects();
        CSVBuilder<BBTB> builder = new CSVBuilder<>();
        builder.writeCsv(csvWriteFilePath, series, BBTB.class, (char) 59);
    }

}
