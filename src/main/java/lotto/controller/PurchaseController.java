package lotto.controller;

import java.util.List;

import lotto.domain.Lotto;
import lotto.service.PurchaseService;

public class PurchaseController {

	private final PurchaseService purchaseService;

	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	public List<Lotto> purchaseLotto(int money) {
		return purchaseService.purchaseLotto(money);
	}
}
