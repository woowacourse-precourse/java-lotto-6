package lotto.domain;

import static lotto.configuration.IntegerConstants.MAX_NUMBER_COUNT_OF_LOTTO;
import static lotto.configuration.IntegerConstants.MAX_NUMBER_RANGE;
import static lotto.configuration.IntegerConstants.MIN_NUMBER_RANGE;
import static lotto.configuration.StringConstants.SEPERATE_STANDARD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.IntegerListUtil;
import lotto.util.StringUtil;
import lotto.validation.IntegerListValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create(String input) {
        input=StringUtil.deleteAllSpaces(input);
        List<Integer> numbers = IntegerListUtil.parseListseperatedBy(
                input, SEPERATE_STANDARD.getValue());
        return new Lotto(numbers);
    }

    public static Lotto createRandomSorted() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                1, 45, 6);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

    public boolean doesContain(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        IntegerListValidator.validateDuplicated(numbers);
        IntegerListValidator.validateSize(numbers, MAX_NUMBER_COUNT_OF_LOTTO.getValue());
        IntegerListValidator.validateEachIntegerInRange(
                numbers, MIN_NUMBER_RANGE.getValue(), MAX_NUMBER_RANGE.getValue());
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
