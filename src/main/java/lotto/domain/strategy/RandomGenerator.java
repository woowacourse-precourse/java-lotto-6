package lotto.domain.strategy;

import java.util.List;

public interface RandomGenerator<T> {
    List<T> generate();
}
