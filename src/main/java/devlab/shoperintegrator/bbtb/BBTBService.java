package devlab.shoperintegrator.bbtb;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import devlab.shoperintegrator.shoper.models.output.OutputFile;
import devlab.shoperintegrator.utils.ParserXML;
import devlab.shoperintegrator.utils.csv.CSVBuilder;
import devlab.shoperintegrator.utils.csv.CSVFacade;
import devlab.shoperintegrator.utils.csv.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BBTBService implements CSVFacade {
    public static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final BBTBMapper mapper;

    public BBTBService(BBTBMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void generateCSV(String inPath, String outPath) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        if (StringUtils.startsWith(inPath, "https")) {
            String file = FileUtils.downloadFile(inPath, outPath, "bbtb_");
            ParserXML.parseFile(file, mapper);
        } else {
            ParserXML.parseFile(inPath, mapper);
        }
        String fileName = "bbtb_" + System.currentTimeMillis() + ".csv";
        List<OutputFile> series = mapper.getObjects();
        CSVBuilder<OutputFile> builder = new CSVBuilder<>();
        builder.writeCsv(outPath + fileName, series, OutputFile.class, (char) 59); // separator ;
    }
}
