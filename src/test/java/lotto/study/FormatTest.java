package lotto.study;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

public class FormatTest {
    @Test
    void 소수점_테스트() {
        long winningPrice = 5250;
        int inputPrice = 8000;
        double rate = (double) winningPrice / inputPrice;
        System.out.println(rate);
        DecimalFormat decimalFormat = new DecimalFormat("###,###.0%");
        String format = decimalFormat.format(rate);
        System.out.println(format);

        long winningPrice2 = 0;
        int inputPrice2 = 8000;
        double rate2 = (double) winningPrice2 / inputPrice2;
        System.out.println(rate2);
        DecimalFormat decimalFormat2 = new DecimalFormat("###,###.0%");
        String format2 = decimalFormat2.format(rate2);
        System.out.println(format2);

        long winningPrice3 = 2000000000;
        int inputPrice3 = 8000;
        double rate3 = (double) winningPrice3 / inputPrice3;
        System.out.println(rate3);
        DecimalFormat decimalFormat3 = new DecimalFormat("###,###.0%");
        String format3 = decimalFormat3.format(rate3);
        System.out.println(format3);

        long winningPrice4 = 253;
        int inputPrice4 = 5000;
        double rate4 = (double) winningPrice4 / inputPrice4;
        System.out.println(rate4);
        DecimalFormat decimalFormat4 = new DecimalFormat("###,###.0%");
        String format4 = decimalFormat4.format(rate4);
        System.out.println(format4);

        long winningPrice5 = 1500000;
        int inputPrice5 = 8000;
        double rate5 = (double) winningPrice5 / inputPrice5;
        System.out.println(rate5);
        DecimalFormat decimalFormat5 = new DecimalFormat("###,###.0%");
        String format5 = decimalFormat5.format(rate5);
        System.out.println(format5);
    }

}
