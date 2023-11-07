package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Number;
import view.Input;

import static lotto.constant.Number.*;

public class Purchase {
    private final Input inputUtil = new Input();

    private final int purchaseAmount;
    private final List<Lotto> myLotto;

    public Purchase(String purchaseInput) {
        this.purchaseAmount = calculatePurchaseAmount(getPurchasePrice(purchaseInput));
        this.myLotto = getMyLotto(purchaseAmount);
    }

    private int getPurchasePrice(String purchaseInput) {
        return Integer.parseInt(purchaseInput);
    }

    public int calculatePurchaseAmount(int purchasePrice) {
        return purchasePrice / PURCHASE_UNIT.getRange();
    }

    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN.getRange(), MAX.getRange(), CNT.getRange());
    }

    private Lotto generateLotto() {
        List<Integer> numbers = generateNumber();
        return new Lotto(numbers);
    }

    public List<Lotto> getMyLotto(int purchaseAmount) {
        List<Lotto> myLotto = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            Lotto lotto = generateLotto();
            myLotto.add(lotto);
        }
        return myLotto;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
