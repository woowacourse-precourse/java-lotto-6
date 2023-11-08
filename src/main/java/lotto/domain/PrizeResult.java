package lotto.domain;

import lotto.Lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private final Map<PrizeMoney, Integer> prizeResult;

    public PrizeResult() {
        prizeResult = new EnumMap<PrizeMoney, Integer>(PrizeMoney.class);
        Arrays.stream(PrizeMoney.values())
                .forEach(prizeMoney -> prizeResult.put(prizeMoney, 0));
    }

    public void calcPrizeResult(WinningLotto winningLotto, Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            PrizeMoney prizeMoney = PrizeMoney.getPrizeMoney(lotto.getMatchLottoNumber(winningLotto),
                    lotto.isContain(winningLotto.getBonusNumber()));
            updatePrizeCount(prizeMoney);
        }
    }

    private void updatePrizeCount(PrizeMoney prizeMoney) {
        prizeResult.put(prizeMoney, prizeResult.get(prizeMoney) + 1);
    }

    public Integer getPrizeCount(PrizeMoney prizeMoney) {
        return prizeResult.get(prizeMoney);
    }
}
