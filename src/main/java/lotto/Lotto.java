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
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_INVALID_SIZE);
        }

        //숫자가 6개가중 1~45사이가 아니거나 중복이 된경우
        boolean[] checkDuplicate = new boolean[LOTTO_NUMBER_END_RANGE + 1];
        for (Integer number : numbers) {
            validateNumber(number);

            if (checkDuplicate[number])
                throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATE_NUMBER);
            checkDuplicate[number] = true;
        }
    }

    private void validateNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_START_RANGE || LOTTO_NUMBER_END_RANGE < bonusNumber) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
    }

    public String getLottoNumbersToPrint() {
        return numbers.toString();
    }

    public HitsNumber calculate(WinningLotto winningLotto) {
        int hitsNumberCnt = getHitsNumberCnt(winningLotto);
        int hitsBonusNumberCnt = getHitsBonusNumberCnt(winningLotto);
        return new HitsNumber(hitsNumberCnt, hitsBonusNumberCnt);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private int getHitsNumberCnt(WinningLotto winningLotto) {
        int hitsNumberCnt = 0;
        for (Integer number : winningLotto.getNumbers()) {
            if (this.numbers.contains(number)) {
                hitsNumberCnt++;
            }
        }
        return hitsNumberCnt;
    }

    private int getHitsBonusNumberCnt(WinningLotto winningLotto) {
        int hitsBonusNumberCnt = 0;
        if (this.numbers.contains(winningLotto.getBonusNum())) {
            hitsBonusNumberCnt++;
        }
        return hitsBonusNumberCnt;
    }
}
