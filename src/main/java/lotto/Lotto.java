package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private List<Integer> numbers = new ArrayList<>();

    public Lotto(List<Integer> numbers) {
        if(validateNumbers(numbers)){
            this.numbers = numbers;
        }
        throw new IllegalArgumentException("[ERROR] 로또는 중복된 번호를 가지거나 6자리 여야합니다.");
    }

    private boolean validateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);

        return numberSet.size() == 6;
    }

    private int countMatchingNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    private int checkBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;

    }

    public int calcuateNumber(List<Integer> winningNumbers, int bonusNumber) {
        int matchNumber = this.countMatchingNumbers(winningNumbers);
        if (matchNumber == 6) {
            return 7;
        } else {
            return matchNumber + this.checkBonusNumber(bonusNumber);
        }
    }
}
