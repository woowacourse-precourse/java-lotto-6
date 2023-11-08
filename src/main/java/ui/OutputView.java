package ui;

import java.text.MessageFormat;
import java.util.List;
import lotto.LottoPrize;
import lotto.LottoPrizeBag;

class OutputView {
    private static final String HORIZON_LINE = "---";
    private static final String STATISTICS = "당첨 통계";
    private static final String PLZ_INPUT_MONEY = "구입 금액을 입력해 주세요.";
    private static final String AMOUNT_FORMAT = "{0}개를 구매했습니다.";
    private static final String PLZ_INPUT_COMMON = "당첨 번호를 입력해 주세요.";
    private static final String PLZ_INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";

    private OutputView() {
    }

    public static void printForInputMoney() {
        System.out.println(PLZ_INPUT_MONEY);
    }

    public static void printAmount(int amount) {
        String formatted = MessageFormat.format(AMOUNT_FORMAT, amount);
        System.out.println(formatted);
    }

    public static void printLottoNumbers(List<String> lottos) {
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printForInputCommonNumber() {
        System.out.println(PLZ_INPUT_COMMON);
    }

    public static void printForInputBonusNumber() {
        System.out.println(PLZ_INPUT_BONUS);
    }

    public static void printStatics(LottoPrizeBag prizeBag) {
        System.out.println(STATISTICS);
        System.out.println(HORIZON_LINE);
        for (LottoPrize prizeLevel : LottoPrize.values()) {
            if (prizeLevel.equals(LottoPrize.NONE)) {
                continue;
            }
            System.out.println(prizeBag.sayAbout(prizeLevel));
        }
    }

    public static void printRateOfReturn(LottoPrizeBag lottoPrizeBag) {
        System.out.printf(RATE_OF_RETURN_FORMAT, lottoPrizeBag.getRateOfReturn());
    }
}
