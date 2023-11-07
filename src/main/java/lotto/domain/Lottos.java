package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos createAutomatic(ThousandUnitMoney purchaseAmount, int oneLottoPrice) {
        int count = purchaseAmount.divide(oneLottoPrice);

        return new Lottos(Stream.generate(() -> Lotto.createRandomSorted())
                .limit(count)
                .collect(Collectors.toList()));
    }

    public int size() {
        return lottos.size();
    }

}
