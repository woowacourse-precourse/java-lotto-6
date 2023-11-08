package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.buyingLottoException;

public class InputView {

	public int inputBuyingPrice() {
		String buyingPrice = Console.readLine();
		buyingLottoException.validateBuyingPrice(buyingPrice);
		return toIntegerNumber(buyingPrice);
		
	}

	private int toIntegerNumber(String buyingPrice) {
		return Integer.parseInt(buyingPrice);
	}

}
