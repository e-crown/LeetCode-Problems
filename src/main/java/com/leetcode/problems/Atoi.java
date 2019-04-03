package leetcode.problems;


public class Atoi {
    /** 
    * @Description:
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。

    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

    当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

    该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

    注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

    在任何情况下，若函数不能进行有效的转换时，请返回 0。

    说明：

    假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

    示例 1:

    输入: "42"
    输出: 42
    示例 2:

    输入: "   -42"
    输出: -42
    解释: 第一个非空白字符为 '-', 它是一个负号。
    我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
    示例 3:

    输入: "4193 with words"
    输出: 4193
    解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
    示例 4:

    输入: "words and 987"
    输出: 0
    解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
    因此无法执行有效的转换。
    示例 5:

    输入: "-91283472332"
    输出: -2147483648
    解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
    因此返回 INT_MIN (−231) 。
    * @Param:  
    * @Return:
    * @Author: cgc
    * @Date: 2019/4/3 
    */
    public int myAtoi(String str) {

        if(str == null || str.length() == 0){
            return 0;
        }
        int strLength = str.length();
        char strChar ;
        String ss  ;
        char sChar = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            strChar = str.charAt(i) ;
            ss = sb.toString();

            if((strChar > '9' || strChar < '0') ){
                //第一个为空格 后面连续空格【过滤连续空格】
                if( (ss.length() == 0) && ((sChar == ' ' || sChar == '\t')) && (strChar == ' ' || strChar == '\t')){
                    continue;
                }
                //只要当前字符不为 +、-、0-9就认为该终止了
                if( !((strChar >= '0' && strChar <='9') || (strChar == '-' || strChar == '+'))){
                    break;
                }
                //
                if((ss.equals("-") || ss.equals("+")) &&  (strChar == '+' || strChar == '-')  ){
                    sb = new StringBuilder("0");
                    break;
                }
                //当前字符为+、-时必须收集的第一个
                if( (ss.length() > 0) &&  (strChar == '+' || strChar == '-' || strChar == ' ' || strChar == '\t') ){
                    break;
                }
            }
            sb.append(str.charAt(i));
        }
        //处理为0结果
        if(sb.length() == 0 || (sb.equals("-") || sb.equals("+"))){
            return 0;
        }
        //符号标识 标记一下，后面做符号判断
        int n = 0;
        if(sb.toString().charAt(0) == '-' ){
            n = -1;
        }if(sb.toString().charAt(0) == '+'){
            n = 1;
        }
        //有+、-的去除
        if(n != 0 ){
            sb.deleteCharAt(0);
        }

        int m = sb.length();
        long sum = 0;
        boolean flag = true;
        //去除首部连续的0，且保证sum在long类型范围内
        for (int j = 0,c = 0; j < m && c < 15; j++) {
            if(sb.charAt(j) == '0' && flag){
                continue;
            }
            flag = false;
            c++;
            sum = sum * 10 + ((sb.charAt(j) - '0') % 10 );
        }
        //超出范围的按照范围最大或最小处理
        if(n >= 0 ){
            sum = sum > Integer.MAX_VALUE ? Integer.MAX_VALUE: sum;
        }else {
            sum = sum > -(long)Integer.MIN_VALUE ? Integer.MIN_VALUE: -sum;
        }
        return (int)sum;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//          System.out.println(new StringBuilder("\0").charAt(0) == '\0');
//          System.out.println(new StringBuilder("12345").deleteCharAt(2));
        System.out.println(new Atoi().myAtoi("  -0000000000012345678"));
    }
}
