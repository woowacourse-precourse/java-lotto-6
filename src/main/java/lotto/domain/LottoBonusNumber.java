package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBonusNumber {

    private final int bonusNumber;

    public LottoBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateDuplicateNumbers(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateNumbers(int bonusNumber, List<Integer> numbers) {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        copiedNumbers.add(bonusNumber);
        long distinctCount = copiedNumbers.stream()
                .distinct()
                .count();

        if (distinctCount != copiedNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
