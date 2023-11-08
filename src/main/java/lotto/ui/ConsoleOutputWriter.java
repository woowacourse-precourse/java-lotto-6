package lotto.ui;

import static lotto.domain.winning.Winning.FIFTH_PLACE;
import static lotto.domain.winning.Winning.FIRST_PLACE;
import static lotto.domain.winning.Winning.FOURTH_PLACE;
import static lotto.domain.winning.Winning.SECOND_PLACE;
import static lotto.domain.winning.Winning.THIRD_PLACE;
import static lotto.ui.OutputMessage.BONUS_NUMBER_INPUT;
import static lotto.ui.OutputMessage.ERROR_FORMAT;
import static lotto.ui.OutputMessage.FIFTH_PLACE_FORMAT;
import static lotto.ui.OutputMessage.FIRST_PLACE_FORMAT;
import static lotto.ui.OutputMessage.FOURTH_PLACE_FORMAT;
import static lotto.ui.OutputMessage.LOTTO_FORMAT;
import static lotto.ui.OutputMessage.PURCHASE_AMOUNT_INPUT;
import static lotto.ui.OutputMessage.PURCHASE_QUANTITY_FORMAT;
import static lotto.ui.OutputMessage.RATE_OF_RETURN_FORMAT;
import static lotto.ui.OutputMessage.SECOND_PLACE_FORMAT;
import static lotto.ui.OutputMessage.THIRD_PLACE_FORMAT;
import static lotto.ui.OutputMessage.WINNING_NUMBERS_INPUT;
import static lotto.ui.OutputMessage.WINNING_STATISTICS_DELIMITER;

import java.util.List;
import lotto.domain.number.Lottos;
import lotto.domain.number.Number;
import lotto.domain.winning.WinningStatistics;

public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public void writePurchaseAmountInput() {
        write(PURCHASE_AMOUNT_INPUT);
    }

    @Override
    public void writeLottos(Lottos lottos) {
        write(PURCHASE_QUANTITY_FORMAT, lottos.countLottos());

        lottos.forEach(lotto -> {
            List<Number> sortedNumbers = lotto.createSortedNumbers();
            Object[] integerArray = sortedNumbers.stream()
                    .map(Number::getValue)
                    .toArray();
            write(LOTTO_FORMAT, integerArray);
        });
    }

    @Override
    public void writeWinningNumbersInput() {
        write(WINNING_NUMBERS_INPUT);
    }

    @Override
    public void writeBonusNumberInput() {
        write(BONUS_NUMBER_INPUT);
    }

    @Override
    public void writeWinningStatistics(WinningStatistics winningStatistics) {
        write(WINNING_STATISTICS_DELIMITER);

        write(FIFTH_PLACE_FORMAT, winningStatistics.count(FIFTH_PLACE));
        write(FOURTH_PLACE_FORMAT, winningStatistics.count(FOURTH_PLACE));
        write(THIRD_PLACE_FORMAT, winningStatistics.count(THIRD_PLACE));
        write(SECOND_PLACE_FORMAT, winningStatistics.count(SECOND_PLACE));
        write(FIRST_PLACE_FORMAT, winningStatistics.count(FIRST_PLACE));

        write(RATE_OF_RETURN_FORMAT, winningStatistics.calculateRateOfReturn());
    }

    @Override
    public void writeError(Exception e) {
        write(ERROR_FORMAT, e.getMessage());
    }

    private void write(Object format, Object... args) {
        System.out.printf(format + "%n", args);
    }
}
