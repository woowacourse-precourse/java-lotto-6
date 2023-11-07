package lotto.domain;

import lotto.utils.RandomNumbersGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count) {
        this.lottos = createLottos(count);
    }

    private List<Lotto> createLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(RandomNumbersGenerator.generateRandomNumber()))
                .collect(Collectors.toList());
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
