package lotto.domain;

import java.util.List;

public class LottoBonusNumber {

    private final int bonusNumber;

    public LottoBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateDuplicateNumbers(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumbers(int bonusNumber, List<Integer> numbers) {
        numbers.add(bonusNumber);
        long distinctCount = numbers.stream()
                .distinct()
                .count();

        if (distinctCount != numbers.size()) {
            numbers.remove(numbers.size() - 1);
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
