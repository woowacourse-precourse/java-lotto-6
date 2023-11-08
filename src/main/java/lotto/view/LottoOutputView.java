package lotto.view;

import lotto.Lotto;
import lotto.domain.Result;

import java.util.List;

import static lotto.constant.LottoConstant.*;
import static lotto.constant.LottoMessage.*;

public class LottoOutputView {

    public void printLottoNumbers(int count, List<Lotto> numbers) {
        printNewLine();
        printMessage(String.format(LOTTO_COUNT.getMessage(), count));
        for (Lotto lotto : numbers) {
            printMessage(lotto.getNumbers().toString());
        }
    }

    public void printWinningStatistics(Result result) {
        printNewLine();
        printMessage(WINNING_STATISTICS.getMessage());
        printMessage(DIVIDE_LINE.getMessage());
        printMessage(String.format(CORRECT_MESSAGE.getMessage(), FIFTH.getConstant(), FIFTH_PRIZE.getMessage(), result.getResults().get(FIFTH_INDEX.getConstant())));
        printMessage(String.format(CORRECT_MESSAGE.getMessage(), FOURTH.getConstant(), FOURTH_PRIZE.getMessage(), result.getResults().get(FOURTH_INDEX.getConstant())));
        printMessage(String.format(CORRECT_MESSAGE.getMessage(), THIRD.getConstant(), THIRD_PRIZE.getMessage(), result.getResults().get(THIRD_INDEX.getConstant())));
        printMessage(String.format(CORRECT_WITH_BONUS.getMessage(), SECOND.getConstant(), SECOND_PRIZE.getMessage(), result.getResults().get(SECOND_INDEX.getConstant())));
        printMessage(String.format(CORRECT_MESSAGE.getMessage(), FIRST.getConstant(), FIRST_PRIZE.getMessage(), result.getResults().get(FIRST_INDEX.getConstant())));
    }

    public void printEarningRate(double earningRate) {
        printMessage(String.format(EARNING_RATE.getMessage(), earningRate));
    }

    public void printMessage(String text) {
        System.out.println(text);
    }

    public void printNewLine() {
        System.out.println();
    }
}
