package lotto;

import lotto.model.HitsNumber;

import java.util.List;

import static lotto.util.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        //숫자가 6개가중 1~45사이가 아니거나 중복이 된경우
        boolean[] checkDuplicate = new boolean[46];
        for (Integer number : numbers) {
            validateNumber(number);

            //중복된 숫자가 있다면
            if (checkDuplicate[number])
                throw new IllegalArgumentException();
            checkDuplicate[number] = true;
        }

    }

    private void validateNumber(int bonusNumber) {
        if (bonusNumber < NUMBER_START_RANGE || LOTTO_END_RANGE < bonusNumber) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    public String getLottoNumbersToPrint() {
        return numbers.toString();
    }

    public HitsNumber calculate(WinningLotto winningLotto) {
        int hitsNumberCnt = 0;
        int hitsBonusNumberCnt = 0;

        for (Integer number : winningLotto.getNumbers()) {
            if (this.numbers.contains(number)) {
                hitsNumberCnt++;
            }
        }

        if (this.numbers.contains(winningLotto.getBonusNum())) {
            hitsBonusNumberCnt++;
        }
        return new HitsNumber(hitsNumberCnt, hitsBonusNumberCnt);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
