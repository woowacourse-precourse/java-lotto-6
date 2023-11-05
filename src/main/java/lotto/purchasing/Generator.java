package lotto.purchasing;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Settings.PURCHASE_UNIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class Generator {
    private final PurchaseAmount purchaseAmount;
    private final List<Lotto> lottos;

    public Generator(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> issue(int issueAmount, int minNumber, int maxNumber, int size) {

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
        return Integer.parseInt(purchaseAmount.ask()) / PURCHASE_UNIT.getNumber();
    }
}