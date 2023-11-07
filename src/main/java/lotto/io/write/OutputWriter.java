package lotto.io.write;

import static lotto.exception.ExceptionConstant.ERROR_PREFIX;
import static lotto.io.read.InputMessage.READ_LOTTO_BONUS_NUMBER;
import static lotto.io.read.InputMessage.READ_LOTTO_WIN_NUMBERS;
import static lotto.io.read.InputMessage.READ_PURCHASE_AMOUNT_MESSAGE;
import static lotto.io.write.OutputMessage.LOTTO_PROFIT_MESSAGE;
import static lotto.io.write.OutputMessage.LOTTO_PURCHASE_AMOUNT_MESSAGE;
import static lotto.io.write.OutputMessage.LOTTO_RESULT_MESSAGE;
import static lotto.io.write.OutputMessage.LOTTO_STATISTICS_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.number.Lotto;
import lotto.domain.result.Grade;

public final class OutputWriter {

    public static void showPurchaseAmountInputMessage() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void showLottoWinNumbersInputMessage() {
        System.out.println(READ_LOTTO_WIN_NUMBERS.getMessage());
    }

    public static void showPurchaseLottoCount(int count) {
        System.out.printf("%d%s\n", count, LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void showLottoBonusNumberInputMessage() {
        System.out.println(READ_LOTTO_BONUS_NUMBER.getMessage());
    }

    public static void showExceptionMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }

    public static void showLottos(List<Lotto> lottos) {
        lottos.forEach(lotto ->
                System.out.println(lottoToString(lotto.getNumbers()))
        );
    }

    private static String lottoToString(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

    public static void showStatistics(Grade grade, Integer count) {
        System.out.printf(LOTTO_STATISTICS_MESSAGE.getMessage(), grade.getDescription(), count);

    }

    public static void showProfit(double percentage) {
        System.out.printf(LOTTO_PROFIT_MESSAGE.getMessage(), percentage);
    }

    public static void showResult() {
        System.out.println(LOTTO_RESULT_MESSAGE.getMessage());
    }
}
