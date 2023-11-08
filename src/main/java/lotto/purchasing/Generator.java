package lotto.purchasing;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Settings.PURCHASE_UNIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class Generator {
    private final Integer totalPurchaseAmount;
    private final List<Lotto> lottos;

    public Generator(Integer totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> issue(int minNumber, int maxNumber, int size) {
        int issueAmount = calculateIssueAmount();

        for (int currentCount = 0; currentCount < issueAmount; currentCount++) {
            List<Integer> randomNumbers = generate(minNumber, maxNumber, size);
            Collections.sort(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
        }

        return lottos;
    }

    private List<Integer> generate(int minNumber, int maxNumber, int size) {
        return new ArrayList<>(pickUniqueNumbersInRange(minNumber, maxNumber, size));
    }

    public int calculateIssueAmount() {
        return totalPurchaseAmount / PURCHASE_UNIT.getNumber();
    }
}