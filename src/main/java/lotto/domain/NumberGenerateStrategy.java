package lotto.domain;

import java.util.List;

@FunctionalInterface
public interface NumberGenerateStrategy {

    List<Integer> createNumber();
}
