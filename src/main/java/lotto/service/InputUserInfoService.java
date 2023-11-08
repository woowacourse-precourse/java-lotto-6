package lotto.service;

import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class InputUserInfoService {
	private final OutputView outputView = new OutputView();
	private final InputView inputView = new InputView();

	public User inputUserInfo() {
		User user = new User(userInputBuyingPrice());
		setUserLottos(user);
		printLottoNumbers(user);
		return user;
	}

	public int userInputBuyingPrice() {
		outputView.askingHowMuchPrice();
		int buyingPrice = inputView.inputBuyingPrice();
		return buyingPrice;
	}
	public void setUserLottos(User user) {
		user.setLottos(getBuyingPrice(user));
		outputView.printAmountOfBuyingLotto(user);
	}
	public void getBuyingPrice(User user) {
		
	}
	public int printLottoNumbers(User user) {
		return user.getBuyingLottosPrice();
	}

}
