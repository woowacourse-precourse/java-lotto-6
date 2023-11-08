package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Comparator {

    public int compare(List<Integer> lotto, List<Integer> lucky) {
        List<Integer> result = lotto.stream()
                .filter(n -> lucky.stream()
                        .anyMatch(Predicate.isEqual(n)))
                .collect(Collectors.toList());

        return result.size();
    }

}
