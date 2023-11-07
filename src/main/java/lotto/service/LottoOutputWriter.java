package lotto.service;

import static lotto.exception.ExceptionConstant.ERROR_PREFIX;
import static lotto.exception.ExceptionConstant.EXCEPTION_MESSAGE_FORMAT;
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
import lotto.io.write.OutputWriter;

public final class LottoOutputWriter {

    private final OutputWriter outputWriter;

    public static LottoOutputWriter of(OutputWriter outputWriter) {
        return new LottoOutputWriter(outputWriter);
    }

    private LottoOutputWriter(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public void showPurchaseAmountInputMessage() {
        outputWriter.write(READ_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void showLottoWinNumbersInputMessage() {
        outputWriter.write(READ_LOTTO_WIN_NUMBERS.getMessage());
    }

    public void showPurchaseLottoSize(int count) {
        outputWriter.write(String.format(LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage(), count));
    }

    public void showLottoBonusNumberInputMessage() {
        outputWriter.write(READ_LOTTO_BONUS_NUMBER.getMessage());
    }

    public void showExceptionMessage(String message) {
        outputWriter.write(String.format(EXCEPTION_MESSAGE_FORMAT, ERROR_PREFIX, message));
    }

    public void showStatistics(Grade grade, Integer count) {
        outputWriter.write(String.format(LOTTO_STATISTICS_MESSAGE.getMessage(), grade.getDescription(), count));
    }

    public void showProfit(double percentage) {
        outputWriter.write(String.format(LOTTO_PROFIT_MESSAGE.getMessage(), percentage));
    }

    public void showResult() {
        outputWriter.write(LOTTO_RESULT_MESSAGE.getMessage());
    }

    public void showLottos(List<Lotto> lottos) {
        String allLottos = lottos.stream()
                .map(it -> it.getNumbers()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ", "[", "]")))
                .collect(Collectors.joining("\n"));

        outputWriter.write(allLottos);
    }
}
