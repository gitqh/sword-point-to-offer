/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序，请完成一个函数，
 * 输入一个这样的数组和一个整数，判断数组中是否含有该整数
 *
 * 思路：
 * 1. 选取数组右上角的数字，若相等，查找结束
 * 2. 若该数字大于要查找的数字，剔除这个数字所在列
 * 3. 若该数字小于要查找的数字，剔除这个数字所在行
 * 4. 若未找到，缩小查找范围，直到找到或查找范围为空
 *
 */
public class NO3_FindFromTwoDimensionArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 7));    // 要查找的数在数组中
        System.out.println(find(matrix, 5));    // 要查找的数不在数组中
        System.out.println(find(matrix, 1));    // 要查找的数是数组中最小的数字
        System.out.println(find(matrix, 15));   // 要查找的数是数组中最大的数字
        System.out.println(find(matrix, 0));    // 要查找的数比数组中最小的数字还小
        System.out.println(find(matrix, 16));   // 要查找的数比数组中最大的数字还大
        System.out.println(find(null, 16));     // 健壮性测试，输入空指针
    }

    public static boolean find(int[][] matrix, int number) {
        //输入parameter检查
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length; //数组行数
        int cols = matrix[0].length; //数组列数
        int row = 0;              //起始行号
        int col = cols-1;         //起始列号
        //保证查找范围在数组之内
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (matrix[row][col] == number) {
                return true;
            } else if (matrix[row][col] > number) {
                col--;
            } else if (matrix[row][col] < number) {
                row++;
            }
        }
        return false;
    }
}
