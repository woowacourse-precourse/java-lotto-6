package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count, LottoNumbers lottoNumbers) {
        this.lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoNumbers.generateNumbers()))
                .collect(Collectors.toList());
    }

    public void printLottoNumbers() {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
