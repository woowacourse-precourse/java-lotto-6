package lotto.model;

import lotto.constant.LottoRank;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoRank> checkRank(WinningNumber winningNumber) {
        List<LottoRank> lottoRanks = new ArrayList<>();

        for (Lotto lotto : lottos) {
            lottoRanks.add(lotto.getRank(winningNumber));
        }
        return lottoRanks;
    }

    public int getSize() {
        return lottos.size();
    }
    public List<Lotto> getLottos() {
        return lottos;
    }
}
