package lotto.constant;

import java.text.NumberFormat;
import java.util.Locale;

public class LottoMessage {

    private static final String PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_RESULT_WRITE_START = "당첨 통계\n---";
    private static final String LOTTO_RESULT_FORMAT = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS_CORRECT = ", 보너스 볼 일치";
    private static final String EMPTY = "";
    private static final NumberFormat formatter = NumberFormat.getInstance(Locale.US);

    public static String getPurchaseAmountInputMessage() {
        return PURCHASE_AMOUNT_INPUT;
    }

    public static String getPurchaseCountMessage(Integer purchaseCount) {
        return String.format(PURCHASE_COUNT_MESSAGE, purchaseCount);
    }

    public static String getWinningNumberInputMessage() {
        return WINNING_NUMBER_INPUT;
    }

    public static String getBonusNumberInputMessage() {
        return BONUS_NUMBER_INPUT;
    }

    public static String getLottoResultWriteStartMessage() {
        return LOTTO_RESULT_WRITE_START;
    }

    public static String getLottoResultMessage(LottoPrize prize, Integer count) {
        return String.format(
            LOTTO_RESULT_FORMAT,
            prize.getCorrectCount(),
            getBonusCorrectMessage(prize.getIsBonusCorrect()),
            formatter.format(prize.getPrize()),
            count
        );
    }

    private static String getBonusCorrectMessage(Boolean isBonusCorrect) {
        if (isBonusCorrect) {
            return BONUS_CORRECT;
        }
        return EMPTY;
    }

    public static String getEmpty() {
        return EMPTY;
    }
}
