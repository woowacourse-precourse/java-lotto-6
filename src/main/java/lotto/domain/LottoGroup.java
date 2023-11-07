package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGroup {
    private List<Lotto> lottos;


    private LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGroup create(int count) {
        return new LottoGroup(IntStream.range(0, count).mapToObj(i -> Lotto.generate()).toList());
    }

    @Override
    public String toString() {
        return lottos
                .stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
