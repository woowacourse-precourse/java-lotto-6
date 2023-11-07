package lotto.view;

import lotto.dto.BonusNumberRequest;
import lotto.dto.MoneyRequest;
import lotto.dto.WinningNumbersRequest;

public class LottoViewImpl implements LottoView {

    @Override
    public MoneyRequest receiveMoney() {
        return MoneyRequest.of(InputView.readMoney());
    }

    @Override
    public WinningNumbersRequest receiveWinningLotto() {
        return WinningNumbersRequest.of(InputView.readWinningLotto());
    }

    @Override
    public BonusNumberRequest receiveBonusNumberRequest() {
        return BonusNumberRequest.of(InputView.readBonusNumber());
    }
}
