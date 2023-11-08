package lotto.view;

import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.PurchasePriceRequest;
import lotto.dto.request.WinningNumberRequest;

public interface InputView {
    PurchasePriceRequest requestPurchasePrice();
    WinningNumberRequest requestWinningNumber();
    BonusNumberRequest requestBonusNumber();
}
