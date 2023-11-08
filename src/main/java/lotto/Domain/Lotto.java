package lotto.Domain;

import lotto.Util.Validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Util.LottoEnum.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
        showNumbers();
    }

    public int lottoResult(List<Integer> winningNumbers, int bonusNumber) {
        int count = countNumbers(winningNumbers);
        boolean bonus = checkBonus(bonusNumber);

        return returnWinner(count, bonus);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> mutableList = new ArrayList<>(numbers);
        Collections.sort(mutableList);
        return mutableList;
    }

    private void showNumbers() {
        System.out.println(numbers);
    }

    private void validate(List<Integer> numbers) {
        Validation.lackInputCheck(numbers);
        Validation.duplicationCheck(numbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int countNumbers(List<Integer> winningNumbers) {
        int count = 0;

        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                count++;
            }
        }

        return count;
    }

    private int returnWinner(int count, boolean bonus) {
        if (count == 3) return FIFTH.getValue();
        if (count == 4) return FOURTH.getValue();
        if (count == 5) return THIRD.getValue();
        if (count == 5 && bonus) return SECOND.getValue();
        if (count == 6) return FIRST.getValue();
        return LOSE.getValue();
    }
}
