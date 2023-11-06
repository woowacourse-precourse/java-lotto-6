package lotto.view;

import lotto.Lotto;
import lotto.domain.Result;

import java.util.List;

import static lotto.constant.LottoConstant.*;
import static lotto.constant.LottoMessage.*;

public class LottoOutputView {

    public void printLottoNumbers(int count, List<Lotto> numbers) {
        printNewLine();
        printMessage(String.format(LOTTO_COUNT, count));
        for (Lotto lotto : numbers) {
            printMessage(lotto.getNumbers().toString());
        }
    }

    public void printWinningStatistics(Result result) {
        printNewLine();
        printMessage(WINNING_STATISTICS);
        printMessage(DIVIDE_LINE);
        printMessage(String.format(CORRECT_MESSAGE, FIFTH, FIFTH_PRIZE, result.getResults().get(FIFTH_INDEX)));
        printMessage(String.format(CORRECT_MESSAGE, FOURTH, FOURTH_PRIZE, result.getResults().get(FOURTH_INDEX)));
        printMessage(String.format(CORRECT_MESSAGE, THIRD, THIRD_PRIZE, result.getResults().get(THRID_INDEX)));
        printMessage(String.format(CORRECT_WITH_BONUS, SECOND, SECOND_PRIZE, result.getResults().get(SECOND_INDEX)));
        printMessage(String.format(CORRECT_MESSAGE, FIRST, FISRT_PRIZE, result.getResults().get(FIRST_INDEX)));
    }

    public void printMessage(String text) {
        System.out.println(text);
    }

    public void printNewLine() {
        System.out.println();
    }
}
