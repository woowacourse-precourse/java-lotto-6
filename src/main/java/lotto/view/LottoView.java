package lotto.view;

public class LottoView implements Output{

	@Override
	public void Intro() {
		System.out.println(GameText.PURCHASE_PRICE.getText());
	}

	@Override
	public void PurchaseCompleted() {
		System.out.println();
	}

	@Override
	public void WinningNumber() {
		System.out.println();
	}

	@Override
	public void BonusNumber() {
		System.out.println();
	}
}
