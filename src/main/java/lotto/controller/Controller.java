package lotto.controller;

import lotto.view.OutputView;
import lotto.view.InputView;
import lotto.dto.AmountDto;
import lotto.dto.EarningDto;
import lotto.dto.LottosDto;
import lotto.dto.WinningDto;

public class Controller {	
	AmountDto amount;
	LottosDto lottos;
	WinningDto winning;
	EarningDto earning;
 	
	public void run() {
		inputAmount();
		outputLotto();
		inputWinning();
		inputBonus();
		outputResult();
	}
	
	private void inputAmount() {
		try {
			OutputView.printInputAmount();
			this.amount = new AmountDto(InputView.askAmount());
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
	
	private void inputBonus() {
		try {
			OutputView.printInputBonus();
			this.winning.setBonus(InputView.askBonus());
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			inputBonus();
		}
	}
	
	private void outputResult() {
		this.earning = new EarningDto(winning.getLottoRankings(lottos.getLottos()));
		OutputView.printResult(earning, amount);
	}
}