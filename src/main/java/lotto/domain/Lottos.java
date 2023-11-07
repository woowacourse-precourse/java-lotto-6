package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        StringBuilder allLottoNumbers = new StringBuilder();
        lottos.forEach(lotto ->  allLottoNumbers.append(lotto.toString()).append("\n"));
        return allLottoNumbers.toString();
    }
}
