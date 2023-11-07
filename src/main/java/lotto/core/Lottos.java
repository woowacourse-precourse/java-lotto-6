package lotto.core;

import lotto.util.LottoConst;
import lotto.util.Rank;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public List<Integer> compareAll(Lotto winningLotto) {
        List<Integer> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            results.add(lotto.compare(winningLotto));
        }
        return results;
    }

    public boolean checkLottoContainsBonusNum(int order, int bonusNum) {
        return lottos.get(order).contains(bonusNum);
    }

    @Override
    public String toString() {
        String res = "";
        for (Lotto lotto : lottos) {
            res += lotto.toString() + "\n";
        }
        return res;
    }
}
