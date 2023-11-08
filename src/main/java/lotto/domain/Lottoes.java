package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.strategy.LottoNumberStrategy;

public class Lottoes {

    public static final int START_INCLUSIVE = 0;

    private final List<Lotto> lottoes;

    public Lottoes(LottoNumberStrategy strategy, int count) {
        this.lottoes = createLottoes(strategy, count);
    }

    public List<Lotto> getAllLotto() {
        return Collections.unmodifiableList(lottoes);
    }

    private List<Lotto> createLottoes(LottoNumberStrategy strategy, int count) {
        return IntStream.range(START_INCLUSIVE, count)
                .mapToObj(i -> createLotto(strategy))
                .collect(Collectors.toList());
    }

    private Lotto createLotto(LottoNumberStrategy strategy) {
        try {
            List<Integer> numbers = strategy.createNumber();
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createLotto(strategy);
        }
    }
}
