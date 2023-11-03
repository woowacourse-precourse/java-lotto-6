package lotto.controller;

import lotto.view.OutputView;
import lotto.view.InputView;
import lotto.dto.AmountDto;
import lotto.dto.LottosDto;

public class Controller {	
	AmountDto amount;
	LottosDto lottos;
	
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
			this.amount = new AmountDto();
			OutputView.printInputAmount();
			purchaseAmount = InputView.askAmount();
			amount.setAmount(purchaseAmount);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			inputAmount();
		}
	}
	
	private void outputLotto() {
		try {
			int availableQuantity = amount.getAvailableQuantity();
			OutputView.printQuantity(availableQuantity);

			this.lottos = new LottosDto(amount.getAvailableQuantity());
			OutputView.printLottos(lottos.getLottos());
		} catch(IllegalArgumentException e) {
			System.out.println(e);
			outputLotto();
		}
	}
	
	private void inputWinning() {
		
	}
	
	private void outputResult() {
		
	}
}