package lotto.domain;

import static lotto.domain.util.Constant.LOTTO_PRICE;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.numbergenerator.NumberGenerator;

public class LottoGenerator {
    private List<Lotto> lottos;

    public List<Lotto> generate(int money, NumberGenerator numberGenerator) {
        makeLottos(money, numberGenerator);
        return Collections.unmodifiableList(lottos);
    }

    private void makeLottos(int money, NumberGenerator numberGenerator) {
        int lottoCount = money / LOTTO_PRICE;
        lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(numberGenerator.generate()))
                .collect(Collectors.toList());
    }
}
