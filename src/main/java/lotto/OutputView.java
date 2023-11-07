package lotto;

import static lotto.OutputMessage.BUY_LOTTO_MESSAGE;
import static lotto.OutputMessage.COUNT_MESSAGE;
import static lotto.OutputMessage.DIVISION_MESSAGE;
import static lotto.OutputMessage.FINISH_MESSAGE;
import static lotto.OutputMessage.INSERT_BONUS_MESSAGE;
import static lotto.OutputMessage.INSERT_NUMBER_MESSAGE;
import static lotto.OutputMessage.INSERT_PRICE_MESSAGE;
import static lotto.OutputMessage.RATE_OF_RETURN_MESSAGE;
import static lotto.OutputMessage.SAME_3_NUMBER_MESSAGE;
import static lotto.OutputMessage.SAME_4_NUMBER_MESSAGE;
import static lotto.OutputMessage.SAME_5_AND_BONUS_BALL_MESSAGE;
import static lotto.OutputMessage.SAME_5_NUMBER_MESSAGE;
import static lotto.OutputMessage.SAME_6_NUMBER_MESSAGE;
import static lotto.OutputMessage.WINNING_STATISTIC_MESSAGE;

import java.util.List;

public class OutputView {

    public void enterMessage() {
        System.out.println();
    }

    public void printPriceMessage() {
        INSERT_PRICE_MESSAGE.print();
    }

    public void printBuyLottoMessage(int count) {
        System.out.println(count + BUY_LOTTO_MESSAGE.get());
    }

    public void printLottoMessage(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printInsertNumberMessage() {
        INSERT_NUMBER_MESSAGE.print();
    }

    public void printInsertBonusMessage() {
        INSERT_BONUS_MESSAGE.print();
    }

    public void printWinningMessage() {
        WINNING_STATISTIC_MESSAGE.print();
    }

    public void printDivisionMessage() {
        DIVISION_MESSAGE.print();
    }

    public void print3NumberMessage(int count) {
        System.out.println(SAME_3_NUMBER_MESSAGE.get() + count + COUNT_MESSAGE.get());
    }

    public void print4NumberMessage(int count) {
        System.out.println(SAME_4_NUMBER_MESSAGE.get() + count + COUNT_MESSAGE.get());
    }

    public void print5NumberMessage(int count) {
        System.out.println(SAME_5_NUMBER_MESSAGE.get() + count + COUNT_MESSAGE.get());
    }

    public void print5BonusMessage(int count) {
        System.out.println(SAME_5_AND_BONUS_BALL_MESSAGE.get() + count + COUNT_MESSAGE.get());
    }

    public void print6BonusMessage(int count) {
        System.out.println(SAME_6_NUMBER_MESSAGE.get() + count + COUNT_MESSAGE.get());
    }

    public void printRateOfReturnMessage(Double rateOfReturn) {
        System.out.println(RATE_OF_RETURN_MESSAGE.get() + String.format("%.1f", rateOfReturn) + FINISH_MESSAGE.get());
    }

}
