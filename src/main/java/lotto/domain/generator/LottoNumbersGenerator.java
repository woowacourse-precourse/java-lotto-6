package lotto.domain.generator;

import java.util.List;

@FunctionalInterface
public interface LottoNumbersGenerator {
    List<Integer> generate();
}
