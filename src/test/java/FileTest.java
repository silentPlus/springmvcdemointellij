import java.io.*;

/**
 * Created by suvan on 2017/11/18.
 */
public class FileTest {

    public static void main(String[] args) {
        String keyword = "通讯录";
        String chart = "GB2312";
        BufferedReader bufferedReader = null;
        FileOutputStream out = null;

        try {
            File file = new File("D:\\logs\\airportmodule.log");

            File newfile = new File("D:\\logs\\directory.txt");
            if (!newfile.exists()) {
                newfile.createNewFile();
            }

            // 读文件流
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));
            // 写文件流
            out = new FileOutputStream(newfile);

            String read = null;
            while ((read = bufferedReader.readLine()) != null) {
                if (read.contains(keyword)) {
                    read += "\r\n";
                    out.write(read.getBytes(chart));
                }
            }
            out.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
