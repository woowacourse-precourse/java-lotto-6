package lotto.util;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class UiVO {

    private static final String BONUS_NUMBER_EXISTS_IN_WINNING_NUMBERS_EXCEPTION
            = "[ERROR] 보너스 번호는 당첨 번호와 다른 숫자여야 합니다.";
    private static final String WINNING_NUMBER_COUNT_EXCEPTION = "[ERROR] 당첨 번호는 서로 다른 숫자 6개 입력해 주세요.";
    private static final String WINNING_NUMBER_FORMAT_EXCEPTION = "[ERROR] 당첨 번호는 쉼표(,)를 기준으로 숫자를 입력해 주세요.";
    private static final String INPUT_NUMBER_FORMAT_EXCEPTION = "[ERROR] 숫자로 입력해 주세요.";
    private static final String PURCHASE_AMOUNT_INPUT_MIN_EXCEPTION = "[ERROR] 구입금액은 1,000 이상 입력해 주세요.";
    private static final String PURCHASE_AMOUNT_INPUT_UNITS_EXCEPTION = "[ERROR] 구입금액은 1,000 단위로 입력해 주세요.";
    private static final String LOTTO_NUMBER_EXCEPTION = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String PURCHASE_AMOUNT_INPUT_TEXT = "구입금액을 입력해 주세요.";
    private static final String BOUGHT_LOTTO_CNT = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_TEXT = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_TEXT = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String MATCHES_FORMAT = "%s개 일치 (%s원) - %d개\n";
    private static final String TOTAL_RETURN_FORMAT = "총 수익률은 %f입니다.";

    public static String getBonusNumberExistsInWinningNumbersException() {
        return BONUS_NUMBER_EXISTS_IN_WINNING_NUMBERS_EXCEPTION;
    }

    public static String getWinningNumberCountException() {
        return WINNING_NUMBER_COUNT_EXCEPTION;
    }

    public static String getWinningNumberFormatException() {
        return WINNING_NUMBER_FORMAT_EXCEPTION;
    }

    public static String getInputNumberFormatException() {
        return INPUT_NUMBER_FORMAT_EXCEPTION;
    }

    public static String getPurchaseAmountInputMinException() {
        return PURCHASE_AMOUNT_INPUT_MIN_EXCEPTION;
    }

    public static String getPurchaseAmountInputUnitsException() {
        return PURCHASE_AMOUNT_INPUT_UNITS_EXCEPTION;
    }

    public static String getLottoNumberException() {
        return LOTTO_NUMBER_EXCEPTION;
    }

    public static void printPurchaseAmountInputText() {
        System.out.println(PURCHASE_AMOUNT_INPUT_TEXT);
        ;
    }

    public static void printBoughtLottoCnt(int count) {
        System.out.println("\n" + count + BOUGHT_LOTTO_CNT);
    }

    public static void printWinningNumberInputText() {
        System.out.println(WINNING_NUMBER_INPUT_TEXT);
    }

    public static void printBonusNumberInputText() {
        System.out.println(BONUS_NUMBER_INPUT_TEXT);
    }

    public static void printLottos(List<Lotto> lottos) {

        for (Lotto lotto : lottos) {
            printLottoNumbers(lotto);
        }
    }

    private static void printLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        StringBuilder sb = new StringBuilder("[");
        for (Integer number : numbers) {
            sb.append(number + ", ");
        }

        sb.deleteCharAt(sb.length() - 2);
        sb.append("]");

        System.out.println(sb.toString());
    }

    public static void printWinningStatistics(Map<MatchType, Integer> winningStatistics) {
        System.out.println(new StringBuilder(WINNING_STATISTICS)
                .append(String.format(MATCHES_FORMAT, "3", "5,000", winningStatistics.get(MatchType.THREE)))
                .append(String.format(MATCHES_FORMAT, "4", "50,000", winningStatistics.get(MatchType.FOUR)))
                .append(String.format(MATCHES_FORMAT, "5", "1,500,000", winningStatistics.get(MatchType.FIVE)))
                .append(String.format(MATCHES_FORMAT, "5", "30,000,000", winningStatistics.get(MatchType.FIVE_BONUS)))
                .append(String.format(MATCHES_FORMAT, "6", "2,000,000,000", winningStatistics.get(MatchType.SIX))));
    }

    public static void printTotalReturn(double totalReturn) {
        System.out.println(String.format(TOTAL_RETURN_FORMAT, totalReturn));
    }
}
