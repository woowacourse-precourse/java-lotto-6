package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private static final int LOTTO_FIXED_CIPHERS = 6;
    private static final int START_INCLUSIVE_LOTTO_NUMBER = 1;
    private static final int END_INCLUSIVE_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto() {
        List<Integer> generatedNumbers = generateNumbers();
        validate(generatedNumbers);
        this.numbers = generatedNumbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_FIXED_CIPHERS) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE_LOTTO_NUMBER, END_INCLUSIVE_LOTTO_NUMBER, LOTTO_FIXED_CIPHERS)
                .stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
