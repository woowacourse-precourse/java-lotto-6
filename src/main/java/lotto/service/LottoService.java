package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoKiosk;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistic;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoNumbers;
import lotto.domain.vo.Money;

public class LottoService {
	private Money userInputAmount;
	private Lotto userLotto;

	public Lotto purchaseLotto(int inputAmount) {
		LottoKiosk lottoKiosk = new LottoKiosk(inputAmount);
		userInputAmount = lottoKiosk.getInputAmount();
		userLotto = lottoKiosk.purchaseLotto();
		return userLotto;
	}

	public void setWinningNumbers(LottoNumbers winnings, LottoNumber bonusNumber) {
		WinningNumbers winningNumbers = new WinningNumbers(winnings, bonusNumber);
		winningNumbers.setLottoResult(userLotto);
	}

	public WinningStatistic getWinningStatistic() {
		return new WinningStatistic(userInputAmount);
	}
}
