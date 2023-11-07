package lotto.model;

import java.util.List;

public class LottoDraw {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public LottoDraw(List<Integer> numbers, int bonusNumber) {
        validateSize(numbers);
        validateDuplicate(numbers, bonusNumber);
        validateScopeNumber(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개의 숫자와 1개의 보너스 번호만 존재합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호 내에는 중복 숫자가 있어서는 안됩니다.");
        } else if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호는 중복될 수 없습니다.");
        }
    }

    private void validateScopeNumber(List<Integer> numbers, int bonusNumber) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }

}
