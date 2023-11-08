package lotto.model;

import static lotto.util.Constants.ERROR;
import static lotto.util.Constants.LOTTO_LENGTH;
import static lotto.util.Constants.MAX_NUMBER;
import static lotto.util.Constants.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class BundleGenerator {
    private static final int START_INCLUSIVE = 1;

    private final PurchaseAmount purchaseAmount;

    private BundleGenerator() {
        throw new AssertionError(ERROR + "기본 생성자로 생성할 수 없습니다.");
    }

    public BundleGenerator(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Map<Lotto, Integer> generateLotto() {
        Map<Lotto, Integer> result = new LinkedHashMap<>();
        for (int round = ZERO; round < this.purchaseAmount.exchangeAmount(); round++) {
            result.put(new Lotto(this.generator()), ZERO);
        }
        return result;
    }

    private List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, MAX_NUMBER, LOTTO_LENGTH);
    }
}
