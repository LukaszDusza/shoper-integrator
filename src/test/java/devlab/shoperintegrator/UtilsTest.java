package devlab.shoperintegrator;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsTest {

    @Test
    public void timestampTest() {
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
        Date resultdate = new Date(yourmilliseconds);
        System.out.println(sdf.format(resultdate));
    }

    @Test
    public void stringSplitTest() {
        String s = "xxx";
        System.out.println(s.split("/")[0]);
        String b = "aaa";
        String[] bs = b.split(" ");
        System.out.println(bs.length);
        System.out.println(bs.length);
    }
}
