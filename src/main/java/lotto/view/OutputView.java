package lotto.view;

import lotto.domain.User;
import lotto.domain.UserLottos;
import lotto.domain.WinningLotto;

import static lotto.util.PrintConstants.*;

import java.util.List;
import java.util.Map;

public class OutputView {

	public void askingHowMuchPrice() {
		System.out.println(INPUT_BUYING_PRICE);
		
	}

	public void printAmountOfBuyingLotto(User user) {
		System.out.println();
		System.out.println(getNumberOfLottos(user)+NUBMER_OF_PURCHASED);
	}

	public int getNumberOfLottos(User user) {
		return user.getBuyingLottosPrice()/1000;
	}

	public void printUserLottoNumbers(User user) {
		List<UserLottos> lottos = user.getLottos();
		for(UserLottos lotto : lottos) {
			System.out.println(lotto.getLottoNumbers());
		}
	}
	public void printAskingLottoNumbers() {
		System.out.println();
		System.out.println(INPUT_NUMBER_OF_LOTTO);
	}
	
	public void printAskingBonusNumber() {
		System.out.println();
		System.out.println(INPUT_BONUS_NUMBER_OF_LOTTO);
	}
	
	public void printWinningStatics(Map<WinningLotto, Integer> winningCount) {
        System.out.println();
        System.out.println(WINNING_STATICS);
        System.out.println(LINE_BREAK);
        System.out.println(THREE_MATCHING_NUMBER + winningCount.getOrDefault(WinningLotto.THIRD, 0) + "개");
        System.out.println(FOUR_MATCHING_NUMBER + winningCount.getOrDefault(WinningLotto.FOURTH, 0) + "개");
        System.out.println(FIVE_MATCHING_NUMBER + winningCount.getOrDefault(WinningLotto.FIFTH, 0) + "개");
        System.out.println(FIVE_MATCHING_BONUS_NOTMATCHING + winningCount.getOrDefault(WinningLotto.FIFTH_WITH_BONUS, 0) + "개");
        System.out.println(SIX_MATCHING_NUMBER + winningCount.getOrDefault(WinningLotto.SIXTH, 0) + "개");
	}
}

