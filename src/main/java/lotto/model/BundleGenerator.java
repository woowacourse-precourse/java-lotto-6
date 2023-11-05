package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class BundleGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    private final PurchaseAmount purchaseAmount;

    public BundleGenerator(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Map<Lotto, Integer> generateLotto() {
        Map<Lotto, Integer> result = new LinkedHashMap<>();
        for (int round = 0; round < this.purchaseAmount.exchangeAmount(); round++) {
            result.put(new Lotto(this.generator()), 0);
        }
        return result;
    }

    private List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }
}
