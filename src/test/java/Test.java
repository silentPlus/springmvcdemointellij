import com.suvan.common.util.NumberUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suvan on 2017/5/15.
 */
public class Test {
    public static void main(String[] args) {
        // String str = "abc你好def";
        // try {
        //     byte[] bytes = str.getBytes("utf-8");
        //     System.out.println(new String(bytes, "utf-8"));
        // } catch (UnsupportedEncodingException e) {
        //     e.printStackTrace();
        // }

        List<byte[]> result = new ArrayList<>();
        String str = "abcdef你好呀ghigklmn我很好opqrstuvwxyz";

        byte[] totalBytes = new byte[0];
        try {
            totalBytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int length = totalBytes.length / 5;
        // System.out.println("total:" + totalBytes.length);
        for (int i = 0; i < length + 1; i++) {
            byte[] temp = new byte[10];
            if (i == 0) {
                temp[0] |= 0x08;
            } else if (i == length) {
                temp[0] |= 0x09;
            } else {
                temp[0] |= 0x0a;
            }

            System.arraycopy(NumberUtils.shortToRH((short)i), 0, temp, 1, 2);// 顺序位，2字节，低位在前，高位在后
            System.arraycopy(new byte[]{0x01}, 0, temp, 3, 1);// uuid 低8字节
            System.arraycopy(new byte[]{0x02}, 0, temp, 4, 1);// UUID 高8字节

            int remainlength = totalBytes.length - i * 5;
            // System.out.println("remain:" + remainlength);
            System.arraycopy(totalBytes, i * 5, temp, 5, remainlength > 5 ? 5 : remainlength);// 数据 493字节
            result.add(temp);
        }

        // System.out.println(result.size());
        byte[] fin = new byte[1000000];
        for (int i = 0; i < result.size(); i++) {
            // System.out.println(NumberUtils.getBooleanArray(b));
            // byte[] a = new byte[2];
            // System.arraycopy(b, 3, a, 0, 2);
            // System.out.println(NumberUtils.getBooleanArray(a));
            byte[] t = result.get(i);
            System.arraycopy(t, 5, fin, i * 5, t.length - 5);
            // System.out.println(new String(t));
            // System.out.println();
        }
        try {
            System.out.println(new String(fin, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }





        /*String str = "1";
        short i = 3;
        UUID uuid = UUID.randomUUID();
        Long.bitCount(uuid.getLeastSignificantBits());
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] buffer = new byte[3];
            buffer[0] |= 0x08;
            System.arraycopy(NumberUtils.shortToLH(i), 0, buffer, 1, bytes.length);
            System.out.println(NumberUtils.getBooleanArray(new byte[]{0x08}));
            System.out.println(NumberUtils.getBooleanArray(buffer));
            System.arraycopy(bytes, 0, buffer, 2, bytes.length);
            System.out.println(NumberUtils.getBooleanArray(buffer));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/

        /*int length = 4;
        for (int i = 0; i < length; i++) {
            byte[] bytes = NumberUtils.shortToRH((short)i);
            System.out.println(bytes.length);
            System.out.println(NumberUtils.getBooleanArray(bytes));
        }*/

        /*long s = 1;
        byte[] bytes = NumberUtils.longToBytes(s);
        System.out.println(bytes.length);
        System.out.println(NumberUtils.getBooleanArray(bytes));
        long q = 2;
        byte[] bytes2 = NumberUtils.longToBytes(q);
        System.out.println(bytes2.length);
        System.out.println(NumberUtils.getBooleanArray(bytes2));*/
    }

}

class A{

}

enum Fruit{
    aaa("1", "2"),
    bbb("3", "4");

    private String color;
    private String weight;

    Fruit(String color, String weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public String getWeight() {
        return weight;
    }

}