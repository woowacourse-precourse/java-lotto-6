package lotto.view;

import java.util.List;

public class OutputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private static final String INPUT_WINNING_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DASHED_LINE = "---";
    private static final String PRIZE_MESSAGE = "%d개 일치%s (%s원) - %d개";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";
    private static final int PRICE_PER_LOTTO = 1000;


    private static void printNewLine() {
        System.out.println();
    }

    public static void notifyInputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public static void notifyLottoPurchase(List<List<Integer>> lottoList) {
        int amount = lottoList.size();

        System.out.println(BUY_LOTTO_MESSAGE.formatted(amount));

        lottoList.forEach(System.out::println);
    }

    public static void notifyInputWinningLottoNumber() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER);
    }

    public static void notifyInputBonusLottoNumber() {
        System.out.println(INPUT_BONUS_LOTTO_NUMBER);
    }


    public static void notifyErrorMessage(String errorMessage) {
        String errorPhrase = "[ERROR] " + errorMessage;
        System.out.println(errorPhrase);
    }
}
