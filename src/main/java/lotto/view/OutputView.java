package lotto.view;

import java.util.List;

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

    public static void printPrizeResult(List<Integer> rates) {

        System.out.println("당첨 통계");
        System.out.println("---");

        StringBuilder result = new StringBuilder();

        result.append("3개 일치 (5,000원) - ");
        result.append(rates.get(4));
        result.append("개\n");

        result.append("4개 일치 (50,000원) - ");
        result.append(rates.get(3));
        result.append("개\n");

        result.append("5개 일치 (1,500,000원) - ");
        result.append(rates.get(2));
        result.append("개\n");

        result.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        result.append(rates.get(1));
        result.append("개\n");

        result.append("6개 일치 (2,000,000,000원) - ");
        result.append(rates.get(0));
        result.append("개");

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
