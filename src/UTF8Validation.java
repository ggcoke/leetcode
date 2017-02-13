/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class UTF8Validation {
    public static boolean validUtf8(int[] data) {
        if (data == null || data.length <= 0) {
            return false;
        }

        int followCount = 0;
        int length = data.length;
        for (int i = 0; i < length; i++) {
            System.out.println("Data[" + i + "] is " + Integer.toHexString(data[i]));
            if (followCount == 0) {
                // start of utf-8 character
                if ((data[i] >> 5) == 0x06) {
                    followCount = 1;
                } else if ((data[i] >> 4) == 0x0e) {
                    followCount = 2;
                } else if ((data[i] >> 3) == 0x1e) {
                    followCount = 3;
                } else if ((data[i] >> 7) != 0) {
                    System.out.println("After lift is " + Integer.toHexString((data[i] >> 7)));
                    System.out.println("Data is " + Integer.toHexString(data[i]) + " in 1");
                    return false;
                }
            } else {
                if ((data[i] >> 6) != 0x02) {
                    System.out.println("Data is " + data[i] + " in 2");
                    return false;
                }
                followCount--;
            }
        }

        return followCount == 0;
    }


    public static void main(String[] args) {
        int[] data = {240,162,138,147};
        boolean result = UTF8Validation.validUtf8(data);
        System.out.println("Result is " + result);
    }
}
