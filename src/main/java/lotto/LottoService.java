package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoService {
	Error error = new Error();
	public int getMoney() {
		Message.PURCHASE_MESSAGE.getMessage();
		String purchaseMoney = Console.readLine().trim();
		error.checkDigitError(purchaseMoney);
		return Integer.parseInt(purchaseMoney);
	}
	public int getLottoCount(int money){
		return money / Number.LOTTO_PRICE.getNumber();
	}
}
