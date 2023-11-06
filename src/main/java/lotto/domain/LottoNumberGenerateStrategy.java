package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface LottoNumberGenerateStrategy {

    List<Integer> createLotto();
}
