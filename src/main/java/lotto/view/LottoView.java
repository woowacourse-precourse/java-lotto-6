package lotto.view;

import java.util.List;
import lotto.dto.response.LottoCollection;
import lotto.dto.response.LottoNumber;

public class LottoView implements Output{

	@Override
	public void Intro() {
		System.out.println(GameText.PURCHASE_PRICE.getText());
	}

	@Override
	public void PurchaseCompleted(LottoCollection lottoCollection) {
		System.out.println(lottoCollection.getLottoCount() + GameText.PURCHASE_COMPLETED.getText());
		for(LottoNumber lottoNumber : lottoCollection.getLottoCollection()){
			System.out.println(lottoNumber.getNumbers());
		}
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
