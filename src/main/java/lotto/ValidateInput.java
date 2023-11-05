package lotto;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class ValidateInput {
	String errorMessage = "[ERROR]";


	public int validateLottoPrice(String input){
		int lottoPrice = 0;
		try {
			lottoPrice = parseInt(input);
		}catch (Exception e){
			throw new IllegalArgumentException(errorMessage + " 정확한 금액을 입력해주세요");
		}

		if (lottoPrice%1000 != 0){
			throw new IllegalArgumentException(errorMessage + " 천원 단위로 금액을 입력해주세요");
		}
		return lottoPrice/1000;
	}

	public List<Integer> validateWinningNumber(String winNumber){
		List<Integer> winningNumbers = new ArrayList<>();
		String[] winningNumberStrings = winNumber.split(",");
		for (String numberStr : winningNumberStrings) {
			try {
				int number = Integer.parseInt(numberStr.trim());
				winningNumbers.add(number);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(errorMessage + " 당첨 번호 입력을 확인해주세요");
			}
		}
		return winningNumbers;
	}

	public int validateBonus(String input){
		int bonus;
		try {
			bonus = parseInt(input);
		}catch (Exception e){
			throw new IllegalArgumentException(errorMessage + "정확한 숫자를 입력해주세요");
		}

		if (bonus > 45 || bonus < 1){
			throw new IllegalArgumentException(errorMessage + "1부터 45까지의 숫자를 입력해주세요");
		}

		return bonus;
	}


}
