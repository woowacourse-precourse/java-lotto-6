package lotto;

import java.util.List;

import lotto.controller.DrawController;
import lotto.controller.PurchaseController;
import lotto.domain.Lotto;
import lotto.service.DrawService;
import lotto.service.PurchaseService;
import lotto.view.Output;

public class Application {
	public static void main(String[] args) {
		PurchaseController purchaseController = new PurchaseController(new PurchaseService());
		DrawController drawController = new DrawController(new DrawService());

		List<Lotto> lottos = purchaseController.purchaseLotto();
		Output.newLine();
		Output.purchaseLottoNumbers(lottos);
		Output.newLine();
		drawController.drawLotto(lottos);
	}
}
