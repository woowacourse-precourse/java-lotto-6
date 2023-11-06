package lotto.service;

import lotto.dto.LottosDto;
import lotto.dto.LottoPurchaseDto;

public interface Service {
    LottoPurchaseDto buyLottery(final String inputPurchaseAmount);

    LottosDto generateLotto(int quantity);
}
