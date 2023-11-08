package lotto.view;

import lotto.domain.User;
import lotto.domain.UserLottos;

import static lotto.util.PrintConstants.*;

import java.util.List;

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
	
}

