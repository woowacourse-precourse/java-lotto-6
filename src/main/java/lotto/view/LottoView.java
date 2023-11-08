package lotto.view;

import lotto.dto.response.LottoCollection;
import lotto.dto.response.LottoNumber;
import lotto.dto.response.WinningResult;

public class LottoView implements Output{

	@Override
	public void Intro() {
		System.out.println(GameText.PURCHASE_PRICE.getText());
	}

	@Override
	public void PurchaseCompleted(LottoCollection lottoCollection) {
		System.out.println("\n" + lottoCollection.getLottoCount()
			+ GameText.PURCHASE_COMPLETED.getText());
		for(LottoNumber lottoNumber : lottoCollection.getLottoCollection()){
			System.out.println(lottoNumber.getNumbers());
		}
	}

	@Override
	public void WinningNumber() {
		System.out.println("\n" + GameText.WINNING_NUMBER.getText());
	}

	@Override
	public void BonusNumber() {
		System.out.println("\n" + GameText.BONUS_NUMBER.getText());
	}

	@Override
	public void result(WinningResult winningResult) {
		System.out.println("\n" + GameText.WINNING_STATISTICS.getText());
		System.out.println(GameText.UNDER_BAR.getText());
		printCorrectCount(winningResult);
		System.out.println(GameText.RATE_OF_RETURN.getText() + winningResult.getRateReturn()
		+ GameText.SENTENCE_END.getText());
	}

	private static void printCorrectCount(WinningResult winningResult) {
		System.out.println(GameText.THREE_CORRECT.getText() + winningResult.getResult()
			.get(GameNumber.THREE_CORRECT_INDEX.getNum()) + GameText.COUNT.getText());
		System.out.println(GameText.FOUR_CORRECT.getText() + winningResult.getResult()
			.get(GameNumber.FOUR_CORRECT_INDEX.getNum()) + GameText.COUNT.getText());
		System.out.println(GameText.FIVE_CORRECT.getText() + winningResult.getResult()
			.get(GameNumber.FIVE_CORRECT_INDEX.getNum()) + GameText.COUNT.getText());
		System.out.println(GameText.FIVE_CORRECT_BONUS.getText() + winningResult.getResult()
			.get(GameNumber.FIVE_CORRECT_BONUS_INDEX.getNum()) + GameText.COUNT.getText());
		System.out.println(GameText.SIX_CORRECT.getText() + winningResult.getResult()
			.get(GameNumber.SIX_CORRECT_INDEX.getNum()) + GameText.COUNT.getText());
	}
}
