package lotto.ui;

import static lotto.domain.winning.Winning.FIFTH_PLACE;
import static lotto.domain.winning.Winning.FIRST_PLACE;
import static lotto.domain.winning.Winning.FOURTH_PLACE;
import static lotto.domain.winning.Winning.SECOND_PLACE;
import static lotto.domain.winning.Winning.THIRD_PLACE;

import java.util.List;
import lotto.domain.number.Lottos;
import lotto.domain.number.Number;
import lotto.domain.winning.WinningStatistics;

public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writePurchaseAmountInput() {
        write(OutputMessage.PURCHASE_AMOUNT_INPUT);
    }

    @Override
    public void writeLottos(Lottos lottos) {
        write(OutputMessage.PURCHASE_QUANTITY_FORMAT, lottos.countLottos());

        lottos.forEach(lotto -> {
            List<Number> sortedNumbers = lotto.createSortedNumbers();
            Object[] integerArray = sortedNumbers.stream()
                    .map(Number::getValue)
                    .toArray();
            write(OutputMessage.LOTTO_FORMAT, integerArray);
        });
    }

    @Override
    public void writeWinningNumbersInput() {
        write(OutputMessage.WINNING_NUMBERS_INPUT);
    }

    @Override
    public void writeBonusNumberInput() {
        write(OutputMessage.BONUS_NUMBER_INPUT);
    }

    @Override
    public void writeWinningStatistics(WinningStatistics winningStatistics) {
        write(OutputMessage.WINNING_STATISTICS_DELIMITER);

        write(OutputMessage.FIFTH_PLACE_FORMAT, winningStatistics.count(FIFTH_PLACE));
        write(OutputMessage.FOURTH_PLACE_FORMAT, winningStatistics.count(FOURTH_PLACE));
        write(OutputMessage.THIRD_PLACE_FORMAT, winningStatistics.count(THIRD_PLACE));
        write(OutputMessage.SECOND_PLACE_FORMAT, winningStatistics.count(SECOND_PLACE));
        write(OutputMessage.FIRST_PLACE_FORMAT, winningStatistics.count(FIRST_PLACE));

        write(OutputMessage.RATE_OF_RETURN_FORMAT, winningStatistics.calculateRateOfReturn());
    }

    @Override
    public void writeError(Exception e) {
        write(OutputMessage.ERROR_FORMAT, e.getMessage());
    }

    private void write(Object format, Object... args) {
        System.out.printf(format + "%n", args);
    }
}
