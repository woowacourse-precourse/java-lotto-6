package lotto.dto;

import java.util.List;
import lotto.validator.LottoNumberValidator;

public record WinningNumberRequest(List<Integer> winningNumber) {

    public WinningNumberRequest {
        LottoNumberValidator.validateLottoNumbers(winningNumber);
    }
}
