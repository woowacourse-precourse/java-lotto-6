package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_COUNT_IN_LOTTO = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<LottoNumber> lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .toList();

        this.numbers = lottoNumbers;
    }

    public static Lotto createDefault() {
        List<Integer> numbers = generateNumbers();
        return new Lotto(numbers);
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
            NUMBER_COUNT_IN_LOTTO);
    }

    private static void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateSize(numbers);
    }

    private static void validateSize(final List<Integer> numbers) {
        if (numbers.size() > NUMBER_COUNT_IN_LOTTO) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(final List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public LottoNumber generateUniqueNumber() {
        LottoNumber number = pickNewNumber();

        while (isContainNumber(number)) {
            number = pickNewNumber();
        }

        return number;
    }

    private static LottoNumber pickNewNumber() {
        return new LottoNumber(
            Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
    }

    public boolean isContainNumber(final LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
