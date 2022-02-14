package devlab.shoperintegrator.b2bTravel;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import devlab.shoperintegrator.shoper.models.output.OutputFile;
import devlab.shoperintegrator.utils.ParserXML;
import devlab.shoperintegrator.utils.csv.CSVBuilder;
import devlab.shoperintegrator.utils.csv.CSVFacade;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.List;

@Component
public class B2BTravelService implements CSVFacade {
    Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    B2BTravelMapper mapper;

    public B2BTravelService(B2BTravelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String downloadFile(String fileURL, String outPath) throws IOException {
        String fileName = "b2b_travel_" + System.currentTimeMillis() + ".xml";
        File file = new File(outPath + fileName);
        FileUtils.copyURLToFile(new URL(fileURL), file);
        return file.getAbsolutePath();
    }

    @Override
    public void generateCSV(String inPath, String outPath) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        if (StringUtils.startsWith(inPath, "https")) {
            String file = downloadFile(inPath, outPath);
            ParserXML.parseFile(file, mapper);
        } else {
            ParserXML.parseFile(inPath, mapper);
        }
        String fileName = "b2b_travel_" + System.currentTimeMillis() + ".csv";
        List<OutputFile> series = mapper.getObjects();
        CSVBuilder<OutputFile> builder = new CSVBuilder<>();
        builder.writeCsv(outPath + fileName, series, OutputFile.class, (char) 59); // separator ;
    }
}
