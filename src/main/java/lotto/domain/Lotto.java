package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

    public static final int VALID_MIN_NUMBER = 1;
    public static final int VALID_MAX_NUMBER = 45;
    public static final int VALID_NUMBER_SIZE = 6;
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = List.copyOf(getLottoNumbersFrom(numbers));
    }

    public static Lotto of(List<Integer> subList) {
        return new Lotto(subList);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> getLottoNumbersFrom(Collection<Integer> numbers) {
        TreeSet<Integer> sorted = numbers.stream()
                .collect(Collectors.toCollection(TreeSet::new));

        return new ArrayList<>(sorted);
    }

    // TODO: 추가 기능 구현
}
