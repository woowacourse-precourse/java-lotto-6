package lotto.domain.lotto;

import lotto.constants.LottoRule;
import lotto.message.ErrorMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoRule.STANDARD.getLottoSize()) {
            throw new IllegalArgumentException();
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

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
