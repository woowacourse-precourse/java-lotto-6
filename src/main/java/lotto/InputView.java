package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	int getPrice() {
		int price;
		while(true) {
			try {
				System.out.println("구입금액을 입력해 주세요.");
				String input = Console.readLine();
				price = validatePriceIsNumber(input);
				validatePriceIsDivideBy1000(price);
				break;
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return price;
	}

	int validatePriceIsNumber(String input) {
		int price;
		try {
			price = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.PRICE_NUMBER.getErrorMsg());
		}
		return price;
	}

	void validatePriceIsDivideBy1000(int price) {
		if(price % 1000 != 0) {
			throw new IllegalArgumentException(ErrorMessage.PRICE_DIVIDE_BY_1000.getErrorMsg());
		}
	}

	String getLottoNumber() {
		String input;
		while(true) {
			System.out.println("당첨 번호를 입력해 주세요.");
			input = Console.readLine();
			try {
				validateLottoIsNumber(input);
				validateLottoNumberRange(input);
				validateLottoNumberLength(input);
				validateLottoNumberNotDuplicate(input);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return input;
	}

	void validateLottoIsNumber(String input) {
		try {
			List<String> inputList = Arrays.asList(input.replaceAll(" ", "").split(","));
			for(String word : inputList) {
				Integer.parseInt(word);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.WINNING_NUM_CONTAIN_NUMBER_AND_COMMA.getErrorMsg());
		}
	}

	void validateLottoNumberRange(String input) {
		List<String> inputList = Arrays.asList(input.replaceAll(" ", "").split(","));
		for(String word : inputList) {
			if(Integer.parseInt(word) <= 0 || Integer.parseInt(word) > 45) {
				throw new IllegalArgumentException(ErrorMessage.WINNING_NUM_RANGE.getErrorMsg());
			}
		}
	}

	void validateLottoNumberLength(String input) {
		List<String> inputList = Arrays.asList(input.replaceAll(" ", "").split(","));
		if(inputList.size() != 6) {
			throw new IllegalArgumentException(ErrorMessage.WINNING_NUM_SIZE.getErrorMsg());
		}
	}

	void validateLottoNumberNotDuplicate(String input) {
		List<String> inputList = Arrays.asList(input.replaceAll(" ", "").split(","));
		for(String num : inputList) {
			List<String> copyList = new ArrayList<>();
			copyList.addAll(inputList);
			copyList.remove(inputList.indexOf(num));
			if(copyList.contains(num)) {
				throw new IllegalArgumentException(ErrorMessage.WINNING_NUM_NOT_DUPLICATE.getErrorMsg());
			}

		}
	}

	int getBonusNumber(Lotto winningLotto) {
		int bonusNumber;
		while(true) {
			try {
				System.out.println("보너스 번호를 입력해 주세요.");
				String input = Console.readLine();
				bonusNumber = validateBonusIsNumber(input);
				validateBonusInRange(bonusNumber);
				validateBonusWithWinningNumber(bonusNumber, winningLotto);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return bonusNumber;
	}

	int validateBonusIsNumber(String input) {
		int bonusNumber;
		try {
			bonusNumber = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_IS_NUMBER.getErrorMsg());
		}
		return bonusNumber;
	}

	void validateBonusInRange(int bonusNumber) {
		if(bonusNumber <= 0 || bonusNumber > 45) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_RANGE.getErrorMsg());
		}
	}

	void validateBonusWithWinningNumber(int bonusNumber, Lotto winningLotto) {
		List<Integer> winningNumbers = winningLotto.getNumbers();
		if(winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_SAME_WINNING_NUM.getErrorMsg());
		}
	}
}
