public class Solution4 {
    public static short parity(long x) {
        short res = 0;
        while (x != 0) {
            res ^= 1;
            x = x & (x - 1);
        }
        return res;
    }


    //    basic we are calculate the x^(y), for example, if we calculate the x^(1010), then is a x^(101+101),
    //    is x^(101)*x^(101), else if we have x^(1011), it is x^(101)*x^(101)*x, it looks like we every time we need to
    //    multiple another x's power to the result if we meet 1 in the power number.
    public static double power(double x, int y) {
        double res = 1.0;
        long power = y;
        if (y < 1) {
            power = -power;
            x = 1.0 / x;
        }
        while (power != 0) {
            if ((power & 1) != 0) {
                res *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return res;
    }

    //    if x is negative, the % operation will give the negative result, for example, if x=-256, x%10=-6;
    public static long reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }
}
