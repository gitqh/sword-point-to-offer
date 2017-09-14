/**
 * 数值的整数次方
 *
 * 考虑指数为负数的情况
 * 不得使用库函数，同时不需要考虑大数问题
 */
public class NO11_Power {

    public static void main(String[] args) {
        System.out.println(0.0000000000000000000000001111 == 0);
        System.out.println(0.0000000000000000000000000000 == 0);
        System.out.println(power(2, -4));
        System.out.println(power(2, 4));
        System.out.println(power(2, 0));
        System.out.println(power(0.00000000000000000000000000001, -1));
        System.out.println(power(0.00000000000000000000000000001, 1));
        System.out.println(power(0.00000000000000000000000000001, 0));
        System.out.println(power(0.00000000000000000000000000000, 0));
    }

    public static double power(double base, int exponent) {
        //判断指数和底数不能同时为0
        if (equal(base,0.0) && exponent == 0) {
            throw new RuntimeException("invalid input");
        }

        if (exponent == 0) {
            return 1;
        }
        long exp = exponent;
        if (exponent < 0) {
            exp = -exp;
        }

        //求幂次方
        double result = powerWithUnsignedExponent(base, exp);
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }


    /**
     * 求一个数的正整数次幂，不考虑溢出
     * @param base
     * @param exp
     * @return
     */
    private static double powerWithUnsignedExponent(double base, long exp) {
        if (exp == 1) {
            return base;
        }
        //递归求一半的值
        double result = powerWithUnsignedExponent(base, exp>>1);
        //求最终的值
        result*=result;
        if ((exp&0x01)==1) {
            result*=base;
        }
        return result;
    }

    private static boolean equal(double num1, double num2) {
        return (num1-num2)>-0.0000001 && (num1-num2)<0.0000001;
    }
}
