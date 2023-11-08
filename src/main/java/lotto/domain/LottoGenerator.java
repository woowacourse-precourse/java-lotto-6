package lotto.domain;

import static lotto.domain.util.Constant.LOTTO_PRICE;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.numbergenerator.NumberGenerator;

public class LottoGenerator {
    private final int money;
    private final NumberGenerator numberGenerator;
    private List<Lotto> lottos;

    public LottoGenerator(int money, NumberGenerator numberGenerator) {
        this.money = money;
        this.numberGenerator = numberGenerator;
    }

    public void makeLottos() {
        int lottoCount = money / LOTTO_PRICE;
        lottos = IntStream.range(0, lottoCount)
                        .mapToObj(i -> new Lotto(makeNumbers()))
                                .collect(Collectors.toList());
    }

    private List<Integer> makeNumbers() {
        return numberGenerator.generate();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
