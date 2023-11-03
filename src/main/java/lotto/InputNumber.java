package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputNumber {
	private final List<Integer> numbers = new ArrayList<>();

	public void getNumber() {
		String userInput = readLine();

	}

	private void stringToList(String input) {
		String[] userNumbers = input.split(",");
		for (String str : userNumbers) {
			numbers.add(Integer.parseInt(str));
		}
	}

	public void isValidInput(String input) { // 사용자가 입력한 값이 숫자가 맞는지 예외처리
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("[ERROR] 금액은 숫자만 입력이 가능합니다.");
			this.getNumber();
		}
	}
}