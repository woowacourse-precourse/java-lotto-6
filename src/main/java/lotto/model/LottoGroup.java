package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class LottoGroup {
    private final List<Lotto> lottos;

    private LottoGroup(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static LottoGroup create(LottoCount lottoCount, NumberGenerator numberGenerator) {
        List<Lotto> lottos = createLottos(lottoCount, numberGenerator);
        return new LottoGroup(lottos);
    }

    private static List<Lotto> createLottos(LottoCount lottoCount, NumberGenerator numberGenerator) {
        return Stream.generate(() -> Lotto.create(numberGenerator))
                .limit(lottoCount.getCount())
                .toList();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
