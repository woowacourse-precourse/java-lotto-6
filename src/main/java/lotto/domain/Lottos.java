package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.domain.enums.LottoReward;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getSize(){
        return lottos.size();
    }
    @Override
    public String toString() {
        List<String> results = lottos.stream()
                .map(Lotto::toString)
                .toList();
        return String.join("\n", results);
    }

    public List<LottoReward> createCompareResults(final WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::findCompareResult)
                .toList();
    }
}