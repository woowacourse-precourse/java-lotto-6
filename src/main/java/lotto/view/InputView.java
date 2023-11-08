package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.constant.ErrorMessage;

public class InputView {
	public int getPrice() {
		int price;
		while (true) {
			try {
				System.out.println("구입금액을 입력해 주세요.");
				String input = Console.readLine();
				price = validatePriceIsNumber(input);
				validatePriceIsDivideBy1000(price);
				break;
			} catch (IllegalArgumentException e) {
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
			throw new IllegalArgumentException(
				ErrorMessage.PRICE_NUMBER.getErrorMsg());
		}
		return price;
	}

	void validatePriceIsDivideBy1000(int price) {
		if (price % 1000 != 0) {
			throw new IllegalArgumentException(
				ErrorMessage.PRICE_DIVIDE_BY_1000.getErrorMsg());
		}
	}

	public String getLottoNumber() {
		String input;
		while (true) {
			System.out.println("당첨 번호를 입력해 주세요.");
			input = Console.readLine();
			try {
				validateLotto(input);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return input;
	}

	void validateLotto(String input) {
		List<String> inputList = Arrays.asList(input
			.replaceAll(" ", "")
			.split(","));

		validateLottoIsNumber(inputList);
		validateLottoNumberRange(inputList);
		validateLottoNumberLength(inputList);
		validateLottoNumberNotDuplicate(inputList);
	}

	void validateLottoIsNumber(List<String> inputList) {
		try {
			for (String word : inputList) {
				Integer.parseInt(word);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
				ErrorMessage.WINNING_NUM_CONTAIN_NUMBER_AND_COMMA.getErrorMsg());
		}
	}

	void validateLottoNumberRange(List<String> inputList) {
		for (String word : inputList) {
			if (Integer.parseInt(word) <= 0 || Integer.parseInt(word) > 45) {
				throw new IllegalArgumentException(
					ErrorMessage.WINNING_NUM_RANGE.getErrorMsg());
			}
		}
	}

	void validateLottoNumberLength(List<String> inputList) {
		if (inputList.size() != 6) {
			throw new IllegalArgumentException(
				ErrorMessage.WINNING_NUM_SIZE.getErrorMsg());
		}
	}

	void validateLottoNumberNotDuplicate(List<String> inputList) {
		for (String num : inputList) {
			List<String> copyList = new ArrayList<>(inputList);
			copyList.remove(inputList.indexOf(num));
			if (copyList.contains(num)) {
				throw new IllegalArgumentException(
					ErrorMessage.WINNING_NUM_NOT_DUPLICATE.getErrorMsg());
			}
		}
	}

	public int getBonusNumber(Lotto winningLotto) {
		int bonusNumber;
		while (true) {
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
			throw new IllegalArgumentException(
				ErrorMessage.BONUS_IS_NUMBER.getErrorMsg());
		}
		return bonusNumber;
	}

	void validateBonusInRange(int bonusNumber) {
		if (bonusNumber <= 0 || bonusNumber > 45) {
			throw new IllegalArgumentException(
				ErrorMessage.BONUS_RANGE.getErrorMsg());
		}
	}

	void validateBonusWithWinningNumber(int bonusNumber, Lotto winningLotto) {
		List<Integer> winningNumbers = winningLotto.getNumbers();
		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(
				ErrorMessage.BONUS_NOT_SAME_WINNING_NUM.getErrorMsg());
		}
	}
}
