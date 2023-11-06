package lotto.service;

import lotto.dto.LottoPurchaseDto;

public interface Service {
    LottoPurchaseDto buyLottery(final String inputPurchaseAmount);
}
