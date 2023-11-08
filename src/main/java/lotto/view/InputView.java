package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.buyingLottoException;

public class InputView {

	public int inputBuyingPrice() {
		try {
			String buyingPrice = Console.readLine();
			buyingLottoException.validateBuyingPrice(buyingPrice);
			return toIntegerNumber(buyingPrice);
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
		}
		
	}

	private int toIntegerNumber(String buyingPrice) {
		return Integer.parseInt(buyingPrice);
	}

}
