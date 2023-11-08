package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * I Always Spent my money to buy Lotto WITHOUT A PENNY LEFT.
 */
public class LottoLover {

    private static int LOTTO_PRICE = 1000;  // Of course, I know it

    private int moneySpent;
    private List<Lotto> bought = new ArrayList<>();

    public LottoLover() {
        moneySpent = 0;
    }

    /**
     * everytime earn Money somehow, I Buy Lotto WITHOUT A PENNY LEFT
     */
    public void earnMoneySomehow(int mustSpentAllWithoutAPennyLeft) {
        if (mustSpentAllWithoutAPennyLeft % LOTTO_PRICE != 0
                || mustSpentAllWithoutAPennyLeft < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    "번 돈은 " + LOTTO_PRICE + "로 나누어 떨어지는 " + LOTTO_PRICE + "이상의 정수여야합니다.");
        }

        int ea = mustSpentAllWithoutAPennyLeft / LOTTO_PRICE;
        for (int i = 0; i < ea; i++) {
            bought.add(new Lotto());
        }
        moneySpent += mustSpentAllWithoutAPennyLeft;
    }

    /**
     * @return "immutable" Lotto List
     */
    public List<Lotto> bragAboutMyLottoButYouAreNotAllowedToTouchIt() {
        return Collections.unmodifiableList(bought);
    }

    public PrizeRecord beholdMyAccomplishment(DrawResult drawResult) {
        PrizeRecord prizeRecord = new PrizeRecord();
        for (Lotto lotto : bought) {
            prizeRecord.accumulate(drawResult.check(lotto), LOTTO_PRICE);
        }

        return prizeRecord;
    }
}
