package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import lotto.util.wrapper.PurchaseAmount;

/**
 * 로또 번호를 생성하는 클래스
 */
public class NumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    private final PurchaseAmount purchaseAmount;

    public NumberGenerator(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public HashMap<Integer, Lotto> generateNumbers() {
        HashMap<Integer, Lotto> result = new HashMap<>();
        for (int round = 0; round < this.purchaseAmount.exchangeAmount(); round++) {
            result.put(round, new Lotto(this.generator()));
        }
        return result;
    }

    private List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }
}
