package devlab.shoperintegrator.utils;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVBuilder<T> {
    public void writeCsv(String stringPath, List<T> series, Class<T> clazz, char separator) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CustomMappingStrategy<T> mappingStrategy = new CustomMappingStrategy<>();
        mappingStrategy.setType(clazz);
        Writer writer = new FileWriter(stringPath);
        StatefulBeanToCsv<T> sbc = new StatefulBeanToCsvBuilder<T>(writer)
                .withSeparator(separator) //;
                .withMappingStrategy(mappingStrategy)
                .build();
        sbc.write(series);
        writer.close();
    }
}
