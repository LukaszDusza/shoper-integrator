package devlab.shoperintegrator.csv;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CreatorCSV {

    public static void generateCSV(String inPath, String outPath, String filePrefix, MapperFacade mapper) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        String suffix = getReadableDate();
        if (StringUtils.startsWith(inPath, "https")) {
            String file = FileUtils.downloadFile(inPath, outPath, filePrefix, suffix);
            ParserXML.parseFile(file, mapper);
        } else {
            ParserXML.parseFile(inPath, mapper);
        }
        String fileName = filePrefix + suffix + ".csv";
        List<OutputFile> series = mapper.getObjects();
        BuilderCSV<OutputFile> builder = new BuilderCSV<>();
        builder.writeCsv(outPath + fileName, series, OutputFile.class, (char) 59); // separator ;
    }

    private static String getReadableDate() {
        long stamp = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
        Date date = new Date(stamp);
        return sdf.format(date);
    }
}
