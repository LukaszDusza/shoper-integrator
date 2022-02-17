package devlab.shoperintegrator.csv;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {

    public static String downloadFile(String fileURL, String outPath, String filePrefix, String suffix) throws IOException {
        String fileName = filePrefix + suffix + ".xml";
        File file = new File(outPath + fileName);
        org.apache.commons.io.FileUtils.copyURLToFile(new URL(fileURL), file);
        return file.getAbsolutePath();
    }
}
