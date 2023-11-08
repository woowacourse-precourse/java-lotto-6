package lotto.view;

import lotto.dto.response.LottoCollection;
import lotto.dto.response.WinningResult;

public interface Output {

	void Intro();

	void PurchaseCompleted(LottoCollection lottoCollection);

	void WinningNumber();

	void BonusNumber();

	void result(WinningResult winningResulte);

}
