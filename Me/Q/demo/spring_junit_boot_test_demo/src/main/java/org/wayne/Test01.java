package org.wayne;

import java.math.BigDecimal;

/**
 * @TODO: new Bigdecimal() 遇上科学计数字符串
 * @author: lwq
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println(888899881);
        final String fuckStr = "2.123456789E9";
        final BigDecimal decimal = new BigDecimal(fuckStr);
        System.out.println(decimal);
        /**
         * 结果 23714694.66   我勒个去
         */
        int i = fuckStr.indexOf(".");
        if (i!=-1) {// 有小数
            int litterLength = fuckStr.length()-i-1;
            int end = litterLength>=3?i+3:i+litterLength;
            final String rs = fuckStr.substring(0, end+1);
            System.out.println(rs);
        }else {//没小数
            final BigDecimal dec = new BigDecimal(fuckStr);
            System.out.println(dec);

        }

    }
}

