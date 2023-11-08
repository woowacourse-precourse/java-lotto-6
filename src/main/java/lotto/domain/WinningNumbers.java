package lotto.domain;

import static lotto.utils.LottoValidateUtils.*;

import java.util.List;

public record WinningNumbers(List<Integer> drawnNumbers, int bonusNumber) {

    public WinningNumbers {
        validateLottoNumbers(drawnNumbers);
        validateBonusNumber(bonusNumber, drawnNumbers);
    }
}
