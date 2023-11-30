package lotto.model;

import lotto.util.Constant;
import lotto.view.InputView;
import lotto.view.OutputView;

public class UserLotto {
	private final LottoDatabase userLotto = new LottoDatabase();

	public UserLotto() {

	}

	public int size() {
		return userLotto.size();
	}

	public Lotto getLottoAt(int index) {
		return userLotto.getIndex(index);
	}

	private void printLotto() {
		OutputView.printReceipt(userLotto.size());
		userLotto.printLotto();
	}

	private void buyLotto() {
		long count = InputView.inputPurchaseAmount() / Constant.LOTTO_PRICE;
		while (count-- > 0) {
			userLotto.add(makeLotto());
		}
	}

	private Lotto makeLotto() {
		return new Lotto(LottoNumberGenerator.randomLottoNumber());
	}
}
