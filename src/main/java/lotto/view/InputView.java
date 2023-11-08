package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.buyingLottoException;
import static lotto.util.buyingLottoException.*;

public class InputView {

	public int inputBuyingPrice() {
		try {
			String buyingPrice = Console.readLine();
			buyingLottoException.validateBuyingPrice(buyingPrice);
			return toIntegerNumber(buyingPrice);
		}catch(NumberFormatException e) {
			throw new IllegalArgumentException(ERROR +LOTTO_PRICE_INPUT_INTEGER_ERROR);
		}
		
	}

	private int toIntegerNumber(String buyingPrice) {
		return Integer.parseInt(buyingPrice);
	}
	
	public String inputLottoNumbers() {
		String lottoNumbers = Console.readLine();
		return lottoNumbers;
	}
	
	public String inputBonusNumber() {
		String bonusNumber = Console.readLine();
		return bonusNumber;
	}

}
