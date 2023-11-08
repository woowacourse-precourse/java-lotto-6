package lotto.policy;

import java.util.Comparator;

@FunctionalInterface
public interface SortPolicy<T> {

    Comparator<T> sort();

}
