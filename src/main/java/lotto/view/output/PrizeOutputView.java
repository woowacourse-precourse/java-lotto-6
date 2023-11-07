package lotto.view.output;

import static lotto.Constants.AMOUNT;
import static lotto.Constants.DASH;

import lotto.model.Prize;

public class PrizeOutputView {
    public void printPrize(Prize prize, int count) {
        System.out.println(prize.getMessage() + DASH + count + AMOUNT);
    }
}
