package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.service.PurchaseService;
import lotto.view.Input;

public class PurchaseController {

	private final PurchaseService purchaseService;

	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	public List<Lotto> purchaseLotto() {
		int money = Input.purchaseAmount();
		return purchaseService.purchaseLotto(money);
	}
}
