package lotto;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateInput {
	private final String errorMessage = "[ERROR]";


	public int validateLottoPrice(String input){
		int lottoPrice = 0;
		try {
			lottoPrice = parseInt(input);
		}catch (Exception e){
			throw new IllegalArgumentException(errorMessage + " 정확한 금액을 입력해주세요");
		}
		if (lottoPrice%1000 != 0) throw new IllegalArgumentException(errorMessage + " 천원 단위로 금액을 입력해주세요");

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
				throw new IllegalArgumentException(errorMessage + " 당첨 번호가 잘못 입력되었습니다.");
			}
		}
		checkLottoWinningNumbers(winningNumbers);
		return winningNumbers;
	}

	public void checkLottoWinningNumbers(List<Integer> winningNumbers){
		Set<Integer> numberSet = new HashSet<>();
		for (int number : winningNumbers) {
			if (winningNumbers.size() != 6) throw new IllegalArgumentException(errorMessage + "당첨 번호는 6자리입니다.");
			if (number > 45 || number < 1) throw new IllegalArgumentException(errorMessage + " 당첨 번호를 확인해주세요");
			if (!numberSet.add(number)) throw new IllegalArgumentException(errorMessage + " 당첨 번호에 중복된 값이 있습니다.");
		}
	}

	public int validateBonus(String inputBonus, List<Integer> winningNumbers){
		int bonus;
		try {
			bonus = parseInt(inputBonus);
		}catch (Exception e){
			throw new IllegalArgumentException(errorMessage + "정확한 숫자를 입력해주세요");
		}
		if (bonus > 45 || bonus < 1) throw new IllegalArgumentException(errorMessage + "1부터 45까지의 숫자를 입력해주세요");
		if (winningNumbers.contains(bonus)) throw new IllegalArgumentException(errorMessage + " 보너스 숫자가 당첨 숫자와 중복됩니다.");

		return bonus;
	}


}
