package com.suvan.common.util;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Created by suvan on 2017/9/27.
 */
public class NumberUtils {
    public static String getBooleanArray(byte[] b) {
        String result = "";
        for (byte o : b) {
            result += byteToBit(o);
        }
        return result;
    }


    /**
     * 将byte转换为一个长度为8的byte数组，数组每个值代表bit
     */
    public static byte[] getBooleanArray(byte b) {
        byte[] array = new byte[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte)(b & 1);
            b = (byte) (b >> 1);
        }
        return array;
    }
    /**
     * 把byte转为字符串的bit
     */
    public static String byteToBit(byte b) {
        return ""
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }

    /**
     * 二进制字符串转byte
     */
    public static byte decodeBinaryString(String byteStr) {
        int re, len;
        if (null == byteStr) {
            return 0;
        }
        len = byteStr.length();
        if (len != 4 && len != 8) {
            return 0;
        }
        if (len == 8) {// 8 bit处理
            if (byteStr.charAt(0) == '0') {// 正数
                re = Integer.parseInt(byteStr, 2);
            } else {// 负数
                re = Integer.parseInt(byteStr, 2) - 256;
            }
        } else {// 4 bit处理
            re = Integer.parseInt(byteStr, 2);
        }
        return (byte) re;
    }

    /**
     * 将short转为低字节在前，高字节在后的byte数组
     * @param n
     * @return
     */
    public static byte[] shortToRH(short n) {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.putShort(n);
        return buffer.array();
        /*byte[] bytes = new byte[2];
        bytes[0] = (byte) (n & 0xff);
        bytes[1] = (byte) (n >> 8 & 0xff);
        return bytes;*/
    }

    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(0, x);
        return buffer.array();
    }
    public static void main(String[] args) {
        /*byte b = 0x35; // 0011 0101
        // 输出 [0, 0, 1, 1, 0, 1, 0, 1]
        System.out.println(Arrays.toString(getBooleanArray(b)));
        // 输出 00110101
        System.out.println(byteToBit(b));
        // JDK自带的方法，会忽略前面的 0
        System.out.println(Integer.toBinaryString(0x35));*/
        UUID uuid = UUID.randomUUID();
        System.out.println(longToBytes(uuid.getLeastSignificantBits()).length);
        System.out.println(longToBytes(uuid.getMostSignificantBits()).length);
        System.out.println(getBooleanArray(longToBytes(uuid.getLeastSignificantBits())));
        System.out.println(getBooleanArray(longToBytes(uuid.getMostSignificantBits())));
    }

}
