package lotto;

import lotto.model.HitsNumber;

import java.util.List;

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
    }

    // TODO: 추가 기능 구현

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
