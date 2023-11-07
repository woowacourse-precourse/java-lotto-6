package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.view.ErrorMessage;

public class Lotto {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE);
        lottoNumbers = sorted(lottoNumbers);
        this.numbers = lottoNumbers;
        System.out.println(numbers);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_LENGTH);
        }
    }

    // TODO: 추가 기능 구현
    private void validateNumberRange(List<Integer> numbers) {
        boolean numberRange = numbers.stream()
                .allMatch(num -> num >= MIN_RANGE && num <= MAX_RANGE);
        if (!numberRange) {
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_NUMBER);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);
        boolean hasDuplicates = lottoNumbers.size() != numbers.size();
        if (hasDuplicates) {
            throw new IllegalArgumentException(ErrorMessage.EXIST_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
