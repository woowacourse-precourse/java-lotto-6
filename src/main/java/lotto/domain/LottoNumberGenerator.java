package lotto.domain;

import lotto.policy.NumberGeneratePolicy;

import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private final NumberGeneratePolicy policy;

    public LottoNumberGenerator(NumberGeneratePolicy policy) {
        this.policy = policy;
    }

    public List<Lotto> generate(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private Lotto generateLotto() {
        return new Lotto(policy.generate());
    }

}
