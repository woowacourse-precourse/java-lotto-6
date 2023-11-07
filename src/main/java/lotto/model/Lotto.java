package lotto.model;

import static lotto.util.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.validator.NumbersValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        NumbersValidator.createValidator().validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = randomPickNumbers();
    }

    public static Lotto createWinningNumbers(String input) {
        NumbersValidator.createValidator().validateNumber(input, WINNING_NUMBERS_PATTERN);
        List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt).toList();
        return new Lotto(numbers);
    }

    private static List<Integer> randomPickNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        LOTTO_MINIMUM_RANGE, LOTTO_MAXIMUM_RANGE, NUMBER_PICK_COUNT)
                .stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
