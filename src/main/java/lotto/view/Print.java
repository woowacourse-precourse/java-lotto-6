package lotto.view;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;

public class Print {
    public static void printPrice(int price) {
        System.out.println(price);
    }
    public static void printBoughtLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotteries(List<List<Integer>> lotteries) {
        for (List<Integer> lotto : lotteries) {
            printLottoNumber(lotto);
        }
    }

    public static void printLottoNumber(List<Integer> lotto) {
        List<String> tmpLotto = new ArrayList<>();
        for (int lottoNumber : lotto) {
            tmpLotto.add(String.valueOf(lottoNumber));
        }
        String allNumber = "[";
        allNumber += String.join(",", tmpLotto);
        allNumber += "]";

        System.out.println(allNumber);
    }

    public static void printStatistics() {

    }

    public static void printMean(float mean) {
        System.out.println("총 수익률은 " + mean + "%입니다.");
    }
}
