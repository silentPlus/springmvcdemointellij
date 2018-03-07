import java.util.Calendar;

/**
 * Created by suvan on 2017/11/1.
 */
public class test1 {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE,30);
        String again_time = "0 " + now.get(Calendar.MINUTE) + " " + now.get(Calendar.HOUR_OF_DAY) + " * * ?";
        System.out.println(again_time);
    }
}
