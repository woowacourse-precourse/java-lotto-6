package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.constant.constants.Config;
import lotto.constant.messages.Error;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicatedNumber(numbers);
        validateLottoSize(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Config.LOTTO_MIN_NUMBER.getConfig() || number > Config.LOTTO_MAX_NUMBER.getConfig()) {
                throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Config.LOTTO_SIZE.getConfig()) {
            throw new IllegalArgumentException(Error.LOTTO_NOT_SIX_NUMBER.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        final Set<Integer> set = new HashSet<>();

        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(Error.LOTTO_DUPLICATED_NUMBER.getMessage());
            }
        }
    }

    public int compare(Lotto lotto) {
        int matched = 0;
        for (Integer number : this.numbers) {
            if (lotto.contains(number)) {
                matched++;
            }
        }
        return matched;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }


    private static void validateToLotto(List<String> numbers) {
        try {
            for (String number : numbers) {
                Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());

        }
    }


    public static Lotto toLotto(String number) {
        List<String> numbers = new ArrayList<>(Arrays.asList(number.split(",")));
        validateToLotto(numbers);

        return new Lotto(numbers.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
    }
}
