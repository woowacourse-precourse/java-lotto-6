package lotto.view;

import lotto.dto.BonusNumberRequest;
import lotto.dto.MoneyRequest;
import lotto.dto.WinningNumbersRequest;

public interface LottoView {
    MoneyRequest receiveMoney();
    WinningNumbersRequest receiveWinningLotto();
    BonusNumberRequest receiveBonusNumberRequest();
}
