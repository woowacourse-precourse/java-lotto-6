package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try {
            validateDuplicateNumber(numbers);
            validateLottoSize(numbers);
            validateNumberRange(numbers);
            throw new IllegalArgumentException();
        } catch (Exception e) {

        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        List<Integer> a = numbers.stream().filter(h -> h < 0 || h > 45).toList();
        if (!a.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        final Set<Integer> set = new HashSet<>();

        for (Integer yourInt : numbers) {
            if (!set.add(yourInt)) {
                throw new IllegalArgumentException();
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


    private boolean validateToLotto(List<String> numbers) {
        boolean isValid = true;
        try {
            for (String number : numbers) {
                Integer.parseInt(number);
            }
            throw new IllegalArgumentException();
        } catch (Exception e) {
            isValid = false;

        }
        return isValid;
    }

    public Lotto toLotto(String number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        List<String> numbers = new ArrayList<String>(Arrays.asList(number.split(",")));
        if (!validateToLotto(numbers)) {
            return null;
        }
        Lotto result = null;
        try {
            result = new Lotto(numbers.stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList()));
            throw new IllegalArgumentException();
        } catch (Exception e) {
            result = null;
        }
        return result;
    }
}
