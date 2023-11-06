package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constants.messages.Error;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicatedNumber(numbers);
        validateLottoSize(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        List<Integer> a = numbers.stream().filter(h -> h < 0 || h > 45).toList();
        if (!a.isEmpty()) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_NOT_SIX_NUMBER.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        final Set<Integer> set = new HashSet<>();

        for (Integer yourInt : numbers) {
            if (!set.add(yourInt)) {
                throw new IllegalArgumentException(Error.LOTTO_DUPLICATED_NUMBER.getMessage());
            }
        }
    }

    public int match(Lotto lotto) {
        int matchedNumber = 0;
        for (int i = 0; i < 6; i++) {
            if (this.numbers.get(i).equals(lotto.numbers.get(i))) {
                matchedNumber++;
            }
        }
        return matchedNumber;
    }

    public void stamp(List<Integer> numbers) {
        assert (numbers.isEmpty());
        for (int i = 0; i < 6; i++) {
            numbers.add(this.numbers.get(i));
        }
    }


    private void validateToLotto(List<String> numbers) {
        try {
            for (String number : numbers) {
                Integer.parseInt(number);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();

        }
    }

    public Lotto toLotto(String number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        List<String> numbers = new ArrayList<>(Arrays.asList(number.split(",")));
        validateToLotto(numbers);

        try {
            return new Lotto(numbers.stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
