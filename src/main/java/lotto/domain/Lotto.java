package lotto.domain;

import java.util.List;
import lotto.dto.LottoDTO;

public class Lotto {
    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = Numbers.from(numbers);
    }

    public LottoDTO getLottoDTO() {
        return LottoDTO.from(numbers.getValue());
    }

    public int countMatchingNumber(WinningNumber winningNumber) {
        return (int) numbers.getValue().stream()
                .filter(winningNumber::contains)
                .count();
    }

    public boolean contains(BonusNumber bonusNumber) {
        return bonusNumber.isBonusNumberContainedInLottoNumbers(numbers.getValue());
    }
}