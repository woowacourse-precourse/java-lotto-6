package lotto;

import java.util.List;

public class SoldLotto {
    private final List<Lotto> lottos;

    public SoldLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .reduce((lottosInformation, lotto) -> lottosInformation + System.lineSeparator() + lotto)
                .get();
    }

    public int getSoldLottoCount() {
        return lottos.size();
    }
}
