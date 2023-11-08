package lotto.service;

import lotto.domain.UserMoney;

public class LottoService {

	public LottoService() {
	}

	private static UserMoney userMoney;

	public void run() {

	}

	public int inputUserMoney() {
		userMoney = new UserMoney();
		return userMoney.buyLottoCount();
	}

}
