package lotto.service;

import lotto.domain.User;
import lotto.view.OutputView;

public class InputUserInfoService {
	private final OutputView outputView = new OutputView();

	public static User inputUserInfo() {
		User user = new User(userInputBuyingPrice());
		return user;
	}

	public int userInputBuyingPrice() {
		outputView.askingHowMuchPrice();
		int buyingPrice = inputView.inputBuyingPrice();
		return buyingPrice;
	}

}
