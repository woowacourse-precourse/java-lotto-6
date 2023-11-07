package lotto.domain.lotto;

import lotto.constants.LottoRule;
import lotto.message.ErrorMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        validateSortedAscending(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.STANDARD.getLottoSize()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>();

        for (int number : numbers) {
            if(!checkNumbers.add(number)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
            }
        }
    }

    public LottoRank determineLottoRank(Lotto winningLotto, int bonus) {
        final List<Integer> winningNumbers = winningLotto.numbers;
        int matchCount = getMatchCount(winningNumbers);

        return LottoRank.getRank(matchCount, isContainsBonus(bonus));
    }

    private int getMatchCount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isContainsBonus(final int bonus) {
        return numbers.contains(bonus);
    }

    private void validateSortedAscending(List<Integer> numbers) {
        List<Integer> sortedNumber = getSortedNumber(numbers);
        if (isNotSort(numbers,sortedNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_NOT_SORTED.getMessage());
        }
    }

    private List<Integer> getSortedNumber(List<Integer> numbers) {
        List<Integer> sortedLotto = new ArrayList<>(numbers);
        Collections.sort(sortedLotto);

        return sortedLotto;
    }

    private boolean isNotSort(List<Integer> numbers, List<Integer> sortedNumber) {
        return !sortedNumber.equals(numbers);
    }

    public void validateLottoNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (isLottoNumberRange(number)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private boolean isLottoNumberRange(int number) {
        return number < LottoRule.STANDARD.getStartNumber() || number > LottoRule.STANDARD.getLastNumber();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
