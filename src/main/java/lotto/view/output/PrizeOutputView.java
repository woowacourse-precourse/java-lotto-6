package lotto.view.output;

import lotto.model.Prize;

public class PrizeOutputView {
    public void printPrize(Prize prize, int count) {
        System.out.println(prize.getMessage() + " - " + count + "개");
    }
}
