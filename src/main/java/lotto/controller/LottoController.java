package lotto.controller;

import lotto.model.RandomLottoGenerator;
import lotto.model.WinningNumbers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

import lotto.message.PrintMessage;
import lotto.model.BonusNumber;
import lotto.model.Lotto;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Lotto;

public class LottoController {
	
	private final InputView inputView;
	private final OutputView outputView;
	private final int LOTTO_PRICE = 1000;
	
	private int lottoAmount; // purchaseAmount/1000;
	private int purchaseAmount;
	
	public LottoController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}
	
	public void run() {
		purchaseLotto();
	}
	
	public void purchaseLotto() { //로또 발행
		lottoAmount = (purchaseAmount = getPurchaseAmount())/LOTTO_PRICE;
		System.out.println();
		outputView.printLottoAmount(lottoAmount);
		
		RandomLottoGenerator randomLotto = new RandomLottoGenerator();
		while(lottoAmount-- > 0) {
			Lotto lotto = new Lotto(randomLotto.lottoNumber());
			System.out.println(lotto.getnumbers());
		}
	}

	private int getPurchaseAmount() { //금액 입력 안내
		outputView.printPurchaseAmount();
		String Amount = inputView.getPurchaseAmount();
		return Integer.parseInt(Amount);
	}
	
	public void getWinningNumber() { //당첨 번호 입력
		outputView.printWinningNumbers();
		WinningNumbers winningNumbers =  new WinningNumbers(inputView.getWinningNumbers());
		winningNumbers.getWinningNumbers();
	}
	
	public void getBonusNumber() { //보너스 번호 입력
		outputView.printBonusNumber();
		BonusNumber bonusNumber = new BonusNumber(inputView.getBonusNumber());
		bonusNumber.getBonusNumber();
	}
	
	
}
