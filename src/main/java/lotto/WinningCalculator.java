package lotto;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningCalculator {

    private final Lottos lottos;
    private final WinningLottoWithBonus winningLottoWithBonus;
    private final Map<Rank, Integer> result = new LinkedHashMap<>();

    public WinningCalculator(Lottos lottos, WinningLottoWithBonus winningLottoWithBonus) {
        init();
        this.lottos = lottos;
        this.winningLottoWithBonus = winningLottoWithBonus;
    }

    private void init() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public Map<Rank, Integer> calculate() {
        for (Lotto lotto : lottos.getLottos()) {
            resultCalculate(lotto);
        }
        return this.result;
    }

    private void resultCalculate(Lotto lotto) {
        Rank rank = getRank(lotto);
        result.put(rank, result.get(rank) + 1);
    }

    private Rank getRank(Lotto lotto) {
        int same = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (winningLottoWithBonus.getLotto().getNumbers().get(i)
                    .equals(lotto.getNumbers().get(i))) {
                same++;
            }
        }
        if (same == 5) {
            if (lotto.getNumbers().contains(winningLottoWithBonus.getBonus())) {
                return Rank.BONUS;
            }
        }
        return Rank.get(same);
    }


}
