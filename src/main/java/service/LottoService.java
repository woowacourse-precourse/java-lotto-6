package service;

import domain.BonusNumber;
import domain.Lotto;
import domain.PurchaseAmount;
import view.InputView;

public class LottoService {
	InputView inputView = new InputView();

	public PurchaseAmount setPurchaseAmount() {
		try {
			return new PurchaseAmount(inputView.enterAmount());
		} catch (NumberFormatException exception) {
			System.out.println(exception.getMessage());
			return setPurchaseAmount();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return setPurchaseAmount();
		}
	}

	public Lotto setWinningLotto() {
		try {
			return new Lotto(inputView.enterWinningLotto());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			return setWinningLotto();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return setWinningLotto();
		}
	}

	public BonusNumber setBonusNumber(Lotto winningLotto) {
		try {
			return new BonusNumber(inputView.enterBonusNumber(), winningLotto);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			return setBonusNumber(winningLotto);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return setBonusNumber(winningLotto);
		}
	}

}
