package lotto.domain;

import java.util.List;

public class SelectedLottoNumber {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public SelectedLottoNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
