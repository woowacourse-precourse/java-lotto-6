package lotto.view;

import lotto.dto.response.LottoCollection;

public interface Output {

	void Intro();

	void PurchaseCompleted(LottoCollection lottoCollection);

	void WinningNumber();

	void BonusNumber();

}
