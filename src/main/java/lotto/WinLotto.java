package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class WinLotto {
	private final List<Integer> winNumbers = new ArrayList<>();

	public WinLotto() {
		this.getSixNumbers();
	}

	private void getSixNumbers() {
		System.out.printf("%n 당첨 번호를 입력해주세요. %n");
		String userInput = readLine().trim();
		this.setWinNumbers(userInput);
		this.checkDuplicateNumber(winNumbers);
	}

	private void setWinNumbers(String input) {
		String[] userChoiceNumbers = input.split(",");

		for (String str : userChoiceNumbers) {
			try {
				int num = Integer.parseInt(str);
				this.checkNumberRange(num);
				winNumbers.add(num);
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] 당첨 번호는 (,)를 구분해서 작성해주세요.");
				this.getSixNumbers();
			} catch (IllegalArgumentException e) {
				this.getSixNumbers();
			}
		}
	}

	private void checkNumberRange(int number) {
		if (number > 45 | number < 1) {
			System.err.println("[ERROR] 숫자는 1~45 사이의 숫자를 입력해주세요.");
			throw new IllegalArgumentException();
		}
	}

	private void checkDuplicateNumber(List<Integer> numbers) {
		Set<Integer> removeDuplicateNumber = new HashSet<>();
		removeDuplicateNumber.addAll(numbers);
		if (numbers.size() != removeDuplicateNumber.size()) {
			System.err.println("[ERROR] 중복된 숫자의 입력은 불가능합니다. 다시 입력해주세요.");
			this.getSixNumbers();
		}
	}
}