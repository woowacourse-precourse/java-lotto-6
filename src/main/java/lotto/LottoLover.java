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
        // ToDo: 돈이 한 푼이라도 남으면 예외를 발생시킨다.
        int ea = mustSpentAllWithoutAPennyLeft / LOTTO_PRICE;
        for (int i = 0; i < ea; i++) {
            bought.add(new Lotto());
        }
    }

    /**
     * @return "immutable" Lotto List
     */
    public List<Lotto> bragAboutMyLottoButYouAreNotAllowedToTouchIt() {
        return Collections.unmodifiableList(bought);
    }
}
