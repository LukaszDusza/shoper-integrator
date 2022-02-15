package devlab.shoperintegrator.utils.csv;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

public interface CSVFacade {

    void generateCSV(String inPath, String outPath) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException;

}
