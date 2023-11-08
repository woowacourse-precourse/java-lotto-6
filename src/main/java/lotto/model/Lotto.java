package lotto.model;

import org.assertj.core.util.Sets;

import java.util.List;

public class Lotto {
    private static final String MESSAGE_ILLEGAL_LOTTO_LENGTH = "[ERROR] 로또 입력 번호는 6개여야 합니다.";
    private static final String MESSAGE_ILLEGAL_LOTTO_NUMBER_RANGE = "[ERROR] 로또 입력 번호는 1에서 45 사이여야 합니다.";
    private static final String MESSAGE_LOTTO_NUMBER_DUPLICATED = "[ERROR] 로또 입력 번호는 중복으로 입력할 수 없습니다.";
    private final List<Integer> numbers;

    private final int LOTTO_LENGTH = 6;

    public Lotto(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH)
            throw new IllegalArgumentException(MESSAGE_ILLEGAL_LOTTO_LENGTH);
    }

    private void validateRange(List<Integer> numbers) {
        long countIllegalNumber = numbers.stream()
                .filter(number -> number <= 0 || number > 45)
                .count();
        if (countIllegalNumber > 0)
            throw new IllegalArgumentException(MESSAGE_ILLEGAL_LOTTO_NUMBER_RANGE);
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.size() != Sets.newHashSet(numbers).size())
            throw new IllegalArgumentException(MESSAGE_LOTTO_NUMBER_DUPLICATED);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < LOTTO_LENGTH - 1; i++) {
            sb.append(numbers.get(i));
            sb.append(", ");
        }
        sb.append(numbers.get(LOTTO_LENGTH-1));
        sb.append("]");
        return sb.toString();
    }

    public WinningRank match(List<Integer> mainNumbers, Integer bonusNumber) {
        int matchedCount = mainNumbers.stream()
                .filter(numbers::contains)
                .toList()
                .size();
        boolean bonus = numbers.contains(bonusNumber);
        return WinningRank.of(matchedCount, bonus);
    }
}
