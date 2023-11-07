package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class OutputView {

    private static final String ERROR_PREFIX_MESSAGE = "[ERROR] : ";
    private static final String PURCHASE_CHECK_MESSAGE = "개를 구매했습니다.";
    private static final String NUMBER_JOIN_DELIMITER = ", ";
    private static final String NUMBER_JOIN_PREFIX = "[";
    private static final String NUMBER_JOIN_SUFFIX = "]";
    private static final String DECIMAL_FORMAT_PATTERN = "#,###";
    private static final String LOTTO_MATCH_COUNT_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String LOTTO_MATCH_COUNT_CONTAIN_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String RESULT_OUTPUT_LINE = "---";
    private static final String RESULT_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final int PERCENTAGE_VALUE = 100;

    public static void printPurchaseResult(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + PURCHASE_CHECK_MESSAGE);
        printEachLotto(lottos);
    }

    private static void printEachLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printJoiningNumber(lotto.getNumbers());
        }
    }

    private static void printJoiningNumber(List<Integer> sortedNumbers) {
        String formattedString = sortedNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(NUMBER_JOIN_DELIMITER, NUMBER_JOIN_PREFIX, NUMBER_JOIN_SUFFIX));

        System.out.println(formattedString);
    }

    public static void printLottoResult(Map<LottoResult, Integer> resultStorage) {
        printResultStartMessage();

        for (LottoResult lottoResultValue : LottoResult.values()) {
            printEachLottoResult(lottoResultValue, resultStorage.get(lottoResultValue));
        }
    }

    private static void printEachLottoResult(LottoResult lottoResultValue, int count) {

        if (lottoResultValue.equals(LottoResult.SECOND)) {
            System.out.printf(LOTTO_MATCH_COUNT_CONTAIN_BONUS_MESSAGE, lottoResultValue.getMatchCount(),
                    convertToDecimalFormat(lottoResultValue.getPrize()), count);
            return;
        }

        System.out.printf(LOTTO_MATCH_COUNT_MESSAGE, lottoResultValue.getMatchCount(),
                convertToDecimalFormat(lottoResultValue.getPrize()), count);
    }


    private static String convertToDecimalFormat(int prize) {
        DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT_PATTERN);
        return decimalFormat.format(prize);
    }

    private static void printResultStartMessage() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(RESULT_OUTPUT_LINE);
    }

    public static void printRateOfReturn(int balance, long prizeAmount) {
        double rateOfReturn = (prizeAmount) / (double) balance * PERCENTAGE_VALUE;
        System.out.printf(RESULT_OF_RETURN_MESSAGE, rateOfReturn);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX_MESSAGE + errorMessage);
    }
}
