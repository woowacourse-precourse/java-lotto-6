package lotto.domain.lotto;

import java.util.List;

public class WinningLottoNumbers {

    private final Lotto numbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

}
