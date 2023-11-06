package lotto.view;

import java.util.List;

public class OutputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String PRINT_RESULT_START_MESSAGE = "\n당첨 통계";
    private static final String SECTION_LINE = "---";
    private static final String PRINT_PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";

    public static void printInputAmountMessage() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    public static void printInputWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public static void printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printLottoCountMessage(int lottoCount) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottoCount));
    }

    public static void printLottos(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printResults(List<String> results, String profit) {
        System.out.println(PRINT_RESULT_START_MESSAGE);
        System.out.println(SECTION_LINE);

        results.forEach(result -> System.out.println(result));

        System.out.println(String.format(PRINT_PROFIT_MESSAGE, profit));
    }


}

