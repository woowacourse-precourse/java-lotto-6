package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lotto.model.BonusNumber;
import lotto.model.WinningLotto;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rating;
import lotto.model.WinningNumbers;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	
	private final InputView inputView;
	private final OutputView outputView;
	private final int LOTTO_PRICE = 1000;
	private List<Lotto> lotto;
	private List<Lotto> lottos;
	private int amount;
	
	public LottoController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}
	
	public void run() {
		lotto = getLottos();
		getWinningLotto(lotto, amount);
	}
	
	public List<Lotto> getLottos(){
		Lottos lottos = new Lottos(getLottoAmount());
		return lottos.getLottos();
	}
	
	private int getLottoAmount() { // 발행 수 
		int money = getPurchaseAmount(); //입력한 금액
		amount = money/LOTTO_PRICE;
		return amount;
	}

	private int getPurchaseAmount() { //금액 입력 안내
		outputView.printMoney();
		String inputMoney = inputView.purchaseAmount();
		Money money = new Money(inputMoney);
		return money.getMoney();
	}
	
	private void getWinningLotto(List<Lotto> lotto, int amount) { // 당첨번호 + 보너스 번호
		WinningLotto winningLotto = new WinningLotto(getWinningNumber(), getBonusNumber());
		System.out.println(winningLotto);
		
	}
	
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
