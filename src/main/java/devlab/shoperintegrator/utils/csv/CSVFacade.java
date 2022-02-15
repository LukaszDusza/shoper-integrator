package devlab.shoperintegrator.utils.csv;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

public interface CSVFacade {

    String downloadFile(String fileURL, String outPath) throws IOException;

    void generateCSV(String inPath, String outPath) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException;

}
