package lotto.domain;

import lotto.dto.WinningNumberDto;

import java.util.List;

public class WinningNumber {

    private Lotto numbers;
    private int bonusNumber;

    public WinningNumber(Lotto numbers) {
        this.numbers = numbers;
        this.bonusNumber = 0;
    }

    public void addBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNormalNumbers() {
        return this.numbers.getNumbers();
    }

}
