package lotto.service;

import lotto.dto.LottosDto;
import lotto.dto.LottoPurchaseDto;
import lotto.dto.WinningResultDto;

public interface Service {
    LottoPurchaseDto buyLottery(final String inputPurchaseAmount);

    LottosDto generateLotto(final int quantity);

    WinningResultDto generateWinningResult(final String inputWinningNumber, final String inputBonusNumber, final LottosDto lottosDto);
}
