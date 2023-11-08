package lotto.util;

import java.text.DecimalFormat;
import java.util.List;
import lotto.Enum.Winning;

public class InteractModule {

    public static void printPurchaseNotice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoGenerateNotice(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printRandomNum(List<Integer> randomNum) {
        System.out.println(randomNum);
    }

    public static void printWinningNumNotice() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNotice() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResultNotice() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printResult(Winning winning, Integer result) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println(winning.getMessage() + "(" + decimalFormat.format(winning.getAmount()) + "원) - " + result + "개");
    }

    public static void printRateOfReturn(int total, Integer tryNum) {
        System.out.printf("총 수익률은 %.1f%%입니다.", ((float) total / tryNum * 100));
    }

    public static void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
