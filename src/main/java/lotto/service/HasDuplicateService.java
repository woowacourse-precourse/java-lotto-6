package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HasDuplicateService {

    public static boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }
}
