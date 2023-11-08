package lotto.util;

import lotto.domain.Prize;
import lotto.domain.Lotto;

import java.util.List;

import static lotto.util.Converter.*;

public class OutputUtils {

    public static void printReadBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBuyCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void printIssuedLottos(List<Lotto> lottos) {
        printBuyCount(lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println("[" + String.join(", ", lotto.getStringNumbers()) + "]");
        }
    }

    public static void printReturnRate(double returnRate) {
        String formatString = convertNumberFormatString(returnRate);
        if (formatString.equals(".0")) {
            formatString = "0.0";
        }
        System.out.println("총 수익률은 " + formatString + "%입니다.");
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printReadPrizeNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printReadBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printStatisticsTitle() {
        System.out.println("\n당첨 통계\n---");
    }

    public static void printStatisticsResult(Prize[] prizes) {
        for (int i = 0; i < prizes.length; ++i) {
            if (i == 3) {
                System.out.println(
                        prizes[i].getPrizeCriteria() + "개 일치, 보너스 볼 일치 " +
                                "(" + convertNumberFormatString(prizes[i].getPrizeAmount()) + "원)" +
                                " - " + prizes[i].getMatchedCount() + "개");
                continue;
            }
            System.out.println(
                    prizes[i].getPrizeCriteria() + "개 일치 " +
                            "(" + convertNumberFormatString(prizes[i].getPrizeAmount()) + "원)" +
                            " - " + prizes[i].getMatchedCount() + "개");
        }
    }


}
