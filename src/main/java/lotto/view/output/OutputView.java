package lotto.view.output;

import static lotto.constant.PrintOutMessage.PLZ_INPUT_BONUS_NUMBER;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_PRICE;
import static lotto.constant.PrintOutMessage.PLZ_INPUT_WINNER_NUMBER;
import static lotto.constant.PrintOutMessage.PRINT_LOTTO_COUNT;
import static lotto.constant.PrintOutMessage.PRINT_WINNING_STATISTICS;

import lotto.model.Lotto;

public class OutputView {
    public void printInputPrice() {
        System.out.println(PLZ_INPUT_PRICE.message);
    }

    public void printLottoCount(int count) {
        System.out.println(count + PRINT_LOTTO_COUNT.message);
    }

    public void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printWinnerNumber() {
        System.out.println(PLZ_INPUT_WINNER_NUMBER.message);
    }

    public void printBonusNumber() {
        System.out.println(PLZ_INPUT_BONUS_NUMBER.message);
    }

    public void printWinningStatistics() {
        System.out.println(PRINT_WINNING_STATISTICS.message);
    }
}
