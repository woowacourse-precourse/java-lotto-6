package lotto.service;

import static lotto.exception.ExceptionConstant.ERROR_PREFIX;
import static lotto.exception.ExceptionConstant.EXCEPTION_MESSAGE_FORMAT;
import static lotto.view.read.InputMessage.READ_LOTTO_BONUS_NUMBER;
import static lotto.view.read.InputMessage.READ_LOTTO_WIN_NUMBERS;
import static lotto.view.read.InputMessage.READ_PURCHASE_AMOUNT_MESSAGE;
import static lotto.view.write.OutputMessage.LOTTO_PROFIT_MESSAGE;
import static lotto.view.write.OutputMessage.LOTTO_PURCHASE_AMOUNT_MESSAGE;
import static lotto.view.write.OutputMessage.LOTTO_RESULT_MESSAGE;
import static lotto.view.write.OutputMessage.LOTTO_STATISTICS_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.Lotto;
import lotto.view.write.OutputView;

public final class LottoMessagePrinter {

    private final OutputView outputView;

    public static LottoMessagePrinter of(OutputView outputView) {
        return new LottoMessagePrinter(outputView);
    }

    private LottoMessagePrinter(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printPurchaseAmountInputMessage() {
        outputView.write(READ_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public void printLottoWinNumbersInputMessage() {
        outputView.write(READ_LOTTO_WIN_NUMBERS.getMessage());
    }

    public void printPurchaseLottoSize(int count) {
        outputView.write(String.format(LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage(), count));
    }

    public void printLottoBonusNumberInputMessage() {
        outputView.write(READ_LOTTO_BONUS_NUMBER.getMessage());
    }

    public void printExceptionMessage(String message) {
        outputView.write(String.format(EXCEPTION_MESSAGE_FORMAT, ERROR_PREFIX, message));
    }

    public void printStatistics(Grade grade, Integer count) {
        outputView.write(String.format(LOTTO_STATISTICS_MESSAGE.getMessage(), grade.getDescription(), count));
    }

    public void printProfit(double percentage) {
        outputView.write(String.format(LOTTO_PROFIT_MESSAGE.getMessage(), percentage));
    }

    public void printResult() {
        outputView.write(LOTTO_RESULT_MESSAGE.getMessage());
    }

    public void printAllLotto(List<Lotto> lottos) {
        String allLotto = lottos.stream()
                .map(it -> it.getNumbers()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ", "[", "]")))
                .collect(Collectors.joining("\n"));

        outputView.write(allLotto);
    }
}
