package lotto.view;

import lotto.model.Rank;
import java.util.List;

import static lotto.model.Rank.*;

public class OutputView {

    public static void printGetPurchasePriceMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoNumMessage(int num) {
        System.out.println();
        StringBuilder lottoNum = new StringBuilder();
        lottoNum.append(num);
        lottoNum.append("개를 구매했습니다.");
        System.out.println(lottoNum);
    }

    public static void printLottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public static void printWinNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printPrizeResult(int[] rankBoard) {

        System.out.println("당첨 통계");
        System.out.println("---");

        StringBuilder result = new StringBuilder();
        Rank[] ranks = Rank.values();

//        Arrays.stream(ranks).forEach(Rank -> System.out.println(getResultMessage(Rank) + rankBoard[Rank.ordinal()] + "개"));

        for (int i = 5; i > 0; i--) {
            System.out.println(getResultMessage(ranks[i-1]) + rankBoard[i] + "개");
        }

        System.out.println(result);
    }

    public static void printRateOfProfit(float rateOfProfit) {

        StringBuilder result = new StringBuilder();

        result.append("총 수익률은 ");
        result.append(String.format("%.1f", rateOfProfit));
        result.append("%입니다.");

        System.out.println(result);
    }

}
