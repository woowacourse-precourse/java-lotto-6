package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningResult;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.utils.Constant.*;
import static lotto.utils.Constant.OutputMessage.*;

public class OutputView {
    public void printLottoQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + MSG_LOTTO_QUANTITY);
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }

    public void printLottoResult(Map<WinningResult, Integer> countOfWinningResult) {
        System.out.println();
        System.out.println(MSG_WINNING_STATISTICS);
        System.out.println(MSG_LINE);

        DecimalFormat decimalFormat = new DecimalFormat(FORMAT_PRICE);

        for (WinningResult winningResult : countOfWinningResult.keySet()) {
            if (winningResult == WinningResult.SECOND) {
                System.out.print(MSG_WINNING_WITH_BONUSNUM);
            }
            if (winningResult != WinningResult.SECOND) {
                System.out.print(winningResult.getValue() + MSG_WINNING_WITHOUT_BONUSNUM);
            }
            System.out.println(BLANK + BRACKET_START + decimalFormat.format(winningResult.getPrice()) + MSG_MONEY_UNIT + BRACKET_END + BLANK + LINE + BLANK + countOfWinningResult.getOrDefault(winningResult, 0) + MSG_COUNT_UNIT);
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(MSG_RATE_OF_RETURN_FIRST + rateOfReturn + MSG_RATE_OF_RETURN_END);
    }
}
