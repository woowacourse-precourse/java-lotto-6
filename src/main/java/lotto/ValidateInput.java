package lotto;

import static java.lang.Integer.parseInt;

public class ValidateInput {
	String errorMassage = "[ERROR]";
	public ValidateInput() {

	}

	public int validateLottoPrice(String input){
		int lottoPrice = 0;
		try {
			lottoPrice = parseInt(input);
		}catch (Exception e){
			throw new IllegalArgumentException(errorMassage + " 정확한 금액을 입력해주세요");
		}

		if (lottoPrice%1000 != 0){
			throw new IllegalArgumentException(errorMassage + " 천원 단위로 금액을 입력해주세요");
		}
		return lottoPrice/1000;
	}

	public int[] validateWinningNumber(String winNumber){
		String[] winningNumber = winNumber.split(",");
		int[] winningNumbers = new int[6];

		if (winningNumber.length != 6){
			throw new IllegalArgumentException(errorMassage + " 당첨 번호 입력을 확인해주세요");
		}

		for (int i = 0; i < 6; i++) {
			winningNumbers[i] = parseInt(winningNumber[i]);
		}
		return winningNumbers;
	}

	public int validateBonus(String input){
		int bonus;
		try {
			bonus = parseInt(input);
		}catch (Exception e){
			throw new IllegalArgumentException(errorMassage + "정확한 숫자를 입력해주세요");
		}

		if (bonus > 45 || bonus < 1){
			throw new IllegalArgumentException(errorMassage + "1부터 45까지의 숫자를 입력해주세요");
		}

		return bonus;
	}


}
