package lotto.view;

import lotto.domain.User;
import static lotto.util.PrintConstants.*;

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
}
