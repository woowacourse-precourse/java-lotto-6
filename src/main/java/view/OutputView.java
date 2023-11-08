package view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.Lotto;

public class OutputView {
    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void showLottoList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public static void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }
    public static void printStatistic(String message, int prize, int sameCount) {
        DecimalFormat moneyFormat = new DecimalFormat("###,###");
        String money = moneyFormat.format(prize);
        System.out.println(message + "(" + money + "원) - " + sameCount + "개");
    }

    public static void printEarningRate(double rate) {
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}
