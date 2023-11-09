package lotto.util.matcher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersMatcherImpl implements NumbersMatcher {
    @Override
    public int matches(List<Integer> numbers, List<Integer> target) {
        Set<Integer> usedNumbers = new HashSet<>(numbers);
        usedNumbers.addAll(target);
        return numbers.size() + target.size() - usedNumbers.size();
    }
}
