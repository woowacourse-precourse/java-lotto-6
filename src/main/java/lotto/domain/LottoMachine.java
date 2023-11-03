package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.RandomUtils;

public class LottoMachine {
    public List<Lotto> createAllLotto(int count) {
        return IntStream.range(0, count)
            .mapToObj(c -> RandomUtils.createRandomNumbers())
            .map(Lotto::new)
            .collect(Collectors.toList());
    }
}
