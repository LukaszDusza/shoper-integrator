package devlab.shoperintegrator.utils.csv;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {

    public static String downloadFile(String fileURL, String outPath, String filePrefix) throws IOException {
        String fileName = filePrefix + getReadableDate() + ".xml";
        File file = new File(outPath + fileName);
        org.apache.commons.io.FileUtils.copyURLToFile(new URL(fileURL), file);
        return file.getAbsolutePath();
    }

    private static String getReadableDate() {
        long stamp = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
        Date date = new Date(stamp);
        return sdf.format(date);
    }
}
