package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.service.PurchaseService;
import lotto.view.Input;
import lotto.view.Output;

public class PurchaseController {

	private final PurchaseService purchaseService;

	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	public List<Lotto> purchaseLotto() {
		int money = getMoney();
		return purchaseService.purchaseLotto(money);
	}

	private static int getMoney() {
		try {
			return Input.purchaseAmount();
		} catch (IllegalArgumentException e) {
			Output.exception(e);
		}
		return getMoney();
	}
}
