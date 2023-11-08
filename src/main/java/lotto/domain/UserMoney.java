package lotto.domain;

import lotto.exception.CustomException;

public class UserMoney {

	private static final Integer MIN_LOTTO_MONEY = 1000;
	private final int money;

	public UserMoney(String money) {
		int userMoney = userMoneyToInteger(money);
		this.money = validMoney(userMoney);
	}

	public Integer validMoney(Integer money) {
		if (money % MIN_LOTTO_MONEY != 0 || money <= 0) {
			CustomException.inputLottoMoneyException();
			throw new IllegalArgumentException();
		}
		return money;
	}

	public Integer userMoneyToInteger(String money) {
		try {
			return Integer.parseInt(money);
		} catch (NumberFormatException e) {
			CustomException.inputLottoMoneyException();
			throw new IllegalArgumentException();
		}
	}

	public Integer buyLottoCount() {
		return money / MIN_LOTTO_MONEY;
	}

}
