package lotto.domain;

import static lotto.exception.ErrorMessage.LOTTO_MONEY_INPUT_ERROR;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.numbergenerator.NumberGenerator;
import lotto.exception.LottoException;

public class LottoMachine {
    private final int lottoCount;
    private final NumberGenerator numberGenerator;
    private List<Lotto> lottos;

    public LottoMachine(int lottoCount, NumberGenerator numberGenerator) {
        this.lottoCount = lottoCount;
        this.numberGenerator = numberGenerator;
    }

    public void makeLottos() {
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
