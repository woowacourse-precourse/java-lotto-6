package lotto.entity;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 로또 번호로 이용할 수 없습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }

    }

    public int checkLottoScore(List<Integer> winningNumbers) {
        int count=0;
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean checkLottoBonus(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
