package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public RankCounter getResults(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(compareLotto(lotto, winningLotto));
        }
        return new RankCounter(ranks);
    }

    private Rank compareLotto(Lotto lotto, WinningLotto winningLotto) {
        int matchingNumber = 0;
        Boolean bonusNumber = Boolean.FALSE;
        for (int pos = 0; pos < Lotto.LOTTO_NUMBERS_SIZE; pos++) {
            if (winningLotto.contain(lotto.getLottoNumber(pos))) {
                matchingNumber += 1;
            }
            if (winningLotto.getBonusNumber() == lotto.getLottoNumber(pos)) {
                bonusNumber = Boolean.TRUE;
            }
        }
        return Rank.of(matchingNumber, bonusNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto)
                    .append("\n");
        }
        return sb.toString();
    }

    public Integer size() {
        return lottos.size();
    }
}
