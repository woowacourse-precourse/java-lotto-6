package lotto.module.view;

import static lotto.global.constant.CommonCode.LOTTO_REPORT_TEMPLATE;

import java.util.Map;
import lotto.global.constant.WinAmount;

public class OutputView {
    public static void printEnterBuyAmount() {
        System.out.println("\n구입금액을 입력해 주세요.");
    }

    public static void printEnterWinNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printEnterBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printGameCount(int gameCount) {
        System.out.println(String.format("\n%s개를 구매했습니다.", gameCount));
    }

    public static void printReport(Map<Long, Integer> statics, String calcRate) {
        System.out.println(
                String.format(
                        LOTTO_REPORT_TEMPLATE,
                        statics.getOrDefault(WinAmount.THIRD.getMatchCount(), 0),
                        statics.getOrDefault(WinAmount.FOURTH.getMatchCount(), 0),
                        statics.getOrDefault(WinAmount.FIFTH.getMatchCount(), 0),
                        statics.getOrDefault(WinAmount.FIFTH_WITH_BONUS.getMatchCount(), 0),
                        statics.getOrDefault(WinAmount.SIXTH.getMatchCount(), 0),
                        calcRate
                )
        );
    }
}
