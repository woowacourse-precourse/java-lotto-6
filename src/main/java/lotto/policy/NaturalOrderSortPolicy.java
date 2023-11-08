package lotto.policy;

import java.util.Comparator;

public class NaturalOrderSortPolicy implements SortPolicy<Integer> {

    @Override
    public Comparator<Integer> sort() {
        return Comparator.naturalOrder();
    }

}
