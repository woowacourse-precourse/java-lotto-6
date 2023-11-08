package lotto;

import constant.GameValues;
import error.ErrorMessage;
import java.util.List;
import util.InputValidator;

public class Lotto implements Comparable<Lotto> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        //크기 확인
        if (!InputValidator.isValidListSize(numbers, GameValues.LOTTO_WINNING_NUM_SIZE.getValue())) {
            ErrorMessage.INVALID_WINNING_LOTTO_NUM_VALUE.errorHandle();
        }
        //중복 확인 lotto만
        if (InputValidator.hasDuplicateNum(numbers)) {
            ErrorMessage.DUPLICATE_LOTTO_NUM.errorHandle();
        }
    }


    public boolean isContain(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    private int calContainCount(List<Integer> anOtherLotto) {
        return anOtherLotto.stream()
                .filter(this::isContain)
                .toList()
                .size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }


    @Override
    public int compareTo(Lotto otherLotto) {
        return this.calContainCount(otherLotto.numbers);
    }
}

