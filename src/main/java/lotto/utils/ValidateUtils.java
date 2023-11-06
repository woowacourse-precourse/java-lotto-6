package lotto.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import lotto.exceptions.DuplicateException;
import lotto.exceptions.InvalidNumberRangeException;

public class ValidateUtils {
    public static <T>
    void validateNoDuplicates(Collection<T> collection) {
        Set<T> toSet = new HashSet<>(collection);
        if (toSet.size() != collection.size()) {
            throw new DuplicateException();
        }
    }

    public static <T extends Comparable<T>>
    void validInRanges(Collection<T> collection, T startInclusive, T endInclusive) {
        var validSize = collection.stream()
                .filter(t -> startInclusive.compareTo(t) <= 0  && endInclusive.compareTo(t) >= 0)
                .count();
        if (validSize != collection.size()) {
            throw new InvalidNumberRangeException();
        }
    }
}
