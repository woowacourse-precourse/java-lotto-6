package lotto.model;

import java.util.ArrayList;
import java.util.List;

public final class Lotto {
    private static final String DUPLICATED_LOTTO_NUMBERS_EXCEPTION = "로또에 중복된 숫자가 있습니다.";
    private static final String LOTTO_SIZE_EXCEPTION = "로또는 %d개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = toLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            String exceptionMessage = String.format(LOTTO_SIZE_EXCEPTION, LOTTO_SIZE);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS_EXCEPTION);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return countDistinctNumbers(numbers) != LOTTO_SIZE;
    }

    private static long countDistinctNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .toList();
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto create(NumberGenerator numberGenerator) {
        List<Integer> uniqueNumbers = generateUniqueNumbers(numberGenerator);

        return new Lotto(uniqueNumbers);
    }

    private static List<Integer> generateUniqueNumbers(NumberGenerator numberGenerator) {
        return numberGenerator.generateUniqueNumbers(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, LOTTO_SIZE);
    }

    public LottoPrize determineLottoPrize(WinningCombination winningCombination) {
        int numberOfMatches = countMatchingNumbers(winningCombination);
        boolean isBonusNumberMatched = hasBonusNumber(winningCombination);

        return LottoPrize.of(numberOfMatches, isBonusNumberMatched);
    }

    private int countMatchingNumbers(WinningCombination winningCombination) {
        return (int) numbers.stream()
                .filter(winningCombination::hasLottoNumber)
                .count();
    }

    private boolean hasBonusNumber(WinningCombination winningCombination) {
        return numbers.stream()
                .anyMatch(winningCombination::hasBonusNumber);
    }

    public boolean hasNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
