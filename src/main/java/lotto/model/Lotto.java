package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static List<Integer> getRandomNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
        Set<Integer> nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        while (nonDuplicateNumbers.size() != lottoNumbers.size()) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
            nonDuplicateNumbers = new HashSet<>(lottoNumbers);
        }

        return lottoNumbers;
    }
    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }

        Set<Integer> expectedNumbers = new HashSet<>(numbers);
        if (expectedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
