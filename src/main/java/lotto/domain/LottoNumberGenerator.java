package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerator {

    List<Integer> generate();
}
