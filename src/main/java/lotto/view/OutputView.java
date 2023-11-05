package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_INFO_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_INFO_MESSAGE = "당첨 통계\n---";

    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void printError(String errorText) {
        System.out.println(errorText);
    }

    public static void printMoneyInputMessage() {
        println(MONEY_INPUT_MESSAGE);
    }

    public static void printBuyInfoMessage(long n) {
        println(String.format(BUY_INFO_MESSAGE, n));
    }

    public static void printWinningNumbersInputMessage() {
        println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public static void printBonusNumberInputMessage() {
        println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printWinningStatisticsInfoMessage() {
        println(WINNING_STATISTICS_INFO_MESSAGE);
    }

    public static void printLotto(Lotto lotto) {
        println(lotto.toString());
    }

    public static void printLottos(Lottos lottos) {
        print(lottos.toString());
    }

}
