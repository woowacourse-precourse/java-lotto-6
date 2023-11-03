package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createByCount(int lottoCount, Strategy<List<Integer>> strategy) {

        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(idx -> {
                    List<Integer> lottoNumbers = strategy.generate();
                    Collections.sort(lottoNumbers);
                    return new Lotto(lottoNumbers);
                })
                .toList();

        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottos=" + lottos +
                '}';
    }
}
