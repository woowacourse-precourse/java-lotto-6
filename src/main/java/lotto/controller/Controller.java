package lotto.controller;

import lotto.view.OutputView;
import lotto.view.InputView;
import lotto.dto.AmountDto;

public class Controller {
	AmountDto amount;
	
	public void run() {
		inputAmount();
		outputLotto();
		inputWinning();
		outputResult();
	}
	
	private void inputAmount() {
		int purchaseAmount = 0;
		amount = new AmountDto();
		try {
			OutputView.printInputAmount();
			purchaseAmount = InputView.askAmount();
			amount.setAmount(purchaseAmount);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			inputAmount();
		}
	}
	
	private void outputLotto() {
		
	}
	
	private void inputWinning() {
		
	}
	
	private void outputResult() {
		
	}
}