package lotto.model;

import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningLotto { // 당첨 번호 + 보너스 넘버
	
	private final Lotto winningLotto;
	private final int bonusNumber;
	
	public WinningLotto() { //Lotto winningLotto, int bonusNumber
		this.winningLotto = getWinningNumber();
		this.bonusNumber = getBonusNumber();
	}
	
	OutputView outputView = new OutputView();
	InputView inputView = new InputView();
	
	public Lotto getWinningNumber() { //당첨 번호 입력
		outputView.printWinningNumbers();
		WinningNumbers winningNumbers =  new WinningNumbers(inputView.winningNumbers());
		Lotto winningLottoNumbers = new Lotto(winningNumbers.getWinningNumbers());
		return winningLottoNumbers;
	}
	
	public int getBonusNumber() { //보너스 번호 입력
		outputView.printBonusNumber();
		BonusNumber bonusNumber = new BonusNumber(inputView.bonusNumber());
		return bonusNumber.getBonusNumber();
	}
	
}
