package lotto.view;

import lotto.dto.response.LottoCollection;
import lotto.dto.response.LottoNumber;
import lotto.dto.response.WinningResult;

public class LottoViewV2 implements Output{

	@Override
	public void Intro() {
		System.out.println(GameTextV2.PURCHASE_PRICE.getText());
	}

	@Override
	public void PurchaseCompleted(LottoCollection lottoCollection) {
		System.out.println("\n" + lottoCollection.getLottoCount()
			+ GameTextV2.PURCHASE_COMPLETED.getText());
		for(LottoNumber lottoNumber : lottoCollection.getLottoCollection()){
			System.out.println(lottoNumber.getNumbers());
		}
	}

	@Override
	public void WinningNumber() {
		System.out.println("\n" + GameTextV2.WINNING_NUMBER.getText());
	}

	@Override
	public void BonusNumber() {
		System.out.println("\n" + GameTextV2.BONUS_NUMBER.getText());
	}

	@Override
	public void result(WinningResult winningResult) {
		System.out.println("\n" + GameTextV2.WINNING_STATISTICS.getText());
		System.out.println(GameTextV2.UNDER_BAR.getText());
		printCorrectCount(winningResult);
		System.out.println(GameTextV2.RATE_OF_RETURN.getText() + winningResult.getRateReturn()
			+ GameTextV2.SENTENCE_END.getText());
	}

	private static void printCorrectCount(WinningResult winningResult) {
		System.out.println(GameTextV2.THREE_CORRECT.getText() + winningResult.getResult()
			.get(GameNumber.THREE_CORRECT_INDEX.getNum()) + GameTextV2.COUNT.getText());
		System.out.println(GameTextV2.FOUR_CORRECT.getText() + winningResult.getResult()
			.get(GameNumber.FOUR_CORRECT_INDEX.getNum()) + GameTextV2.COUNT.getText());
		System.out.println(GameTextV2.FIVE_CORRECT.getText() + winningResult.getResult()
			.get(GameNumber.FIVE_CORRECT_INDEX.getNum()) + GameTextV2.COUNT.getText());
		System.out.println(GameTextV2.FIVE_CORRECT_BONUS.getText() + winningResult.getResult()
			.get(GameNumber.FIVE_CORRECT_BONUS_INDEX.getNum()) + GameTextV2.COUNT.getText());
		System.out.println(GameTextV2.SIX_CORRECT.getText() + winningResult.getResult()
			.get(GameNumber.SIX_CORRECT_INDEX.getNum()) + GameTextV2.COUNT.getText());
	}
}

