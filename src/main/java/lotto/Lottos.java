package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(String purchasingAmount) {
        checkPurchasingAmount(purchasingAmount);
        int time = Integer.parseInt(purchasingAmount) / 1000;
        while (this.lottos.size() < time) {
            this.lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    private void checkPurchasingAmount(String purchasingAmount) {
        if (!isValidPurchasingAmount(purchasingAmount))
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000 단위이어야 합니다.");
    }

    private boolean isValidPurchasingAmount(String purchasingAmount) {
        return purchasingAmount.matches("^[1-9]\\d*000$");
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Result makeResult(Lotto winningNumber, int bonusNumber) {
        Result result = new Result(lottos.size());

        for (Lotto lotto : lottos) {
            result.putIt(lotto.getRanking(winningNumber, bonusNumber));
        }
        return result;
    }
}
