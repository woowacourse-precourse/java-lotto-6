package lotto.domain;

import lotto.view.message.ExceptionMessage;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        validateCountNums(numbers);
        validateRange(numbers);
        validateDuplicatedNum(numbers);
    }

    private void validateDuplicatedNum(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != 6) {
            System.out.println(ExceptionMessage.ERROR_MESSAGE_ABOUT_DUPLICATED_LOTTO_NUMBERS.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i=0; i<6; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                System.out.println(ExceptionMessage.ERROR_MESSAGE_ABOUT_WRONG_RANGED_LOTTO_NUMBERS.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateCountNums(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ExceptionMessage.ERROR_MESSAGE_ABOUT_SIX_COUNT.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


    public int compareWithLotto(WinningLotto winningLotto) {
        List<Integer> winningSixLottoNums = winningLotto.getLotto().getNumbers();
        int equalCount = 0;
        for (int i=0; i<6; i++) {
            if (numbers.contains(winningSixLottoNums.get(i))) {
                equalCount++;
            }
        }
        return equalCount;
    }

    public boolean compareWithBonusNum(WinningLotto winningLotto) {
        if (numbers.contains(winningLotto.getBonusNum())) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return numbers.toString();
    }
}
