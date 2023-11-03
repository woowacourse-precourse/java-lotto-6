package lotto.controller;

import lotto.view.OutputView;
import lotto.view.InputView;
import lotto.dto.AmountDto;
import lotto.dto.LottosDto;
import lotto.dto.WinningDto;

public class Controller {	
	AmountDto amount;
	LottosDto lottos;
	WinningDto winning;
	
	public Controller() {
		
	}
 	
	public void run() {
		inputAmount();
		outputLotto();
		inputWinning();
		outputResult();
	}
	
	private void inputAmount() {
		try {
			int purchaseAmount = 0;
			OutputView.printInputAmount();
			purchaseAmount = InputView.askAmount();
			this.amount = new AmountDto(purchaseAmount);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			inputAmount();
		}
	}
	
	private void outputLotto() {
		try {
			int availableQuantity = amount.getAvailableQuantity();
			OutputView.printQuantity(availableQuantity);
			this.lottos = new LottosDto(availableQuantity);
			OutputView.printLottos(lottos.getLottos());
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			outputLotto();
		}
	}
	
	private void inputWinning() {
		try {
			OutputView.printInputWinning();
			this.winning = new WinningDto(InputView.askWinning());
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			inputWinning();
		}
	}
	
	private void outputResult() {
		
	}
}