package lotto;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Winner {
	private final List<Integer> numbers;
	private final int bonusNumber;

	public Winner() {
		this.numbers = readNumbers();
		this.bonusNumber = readBonusNumbers();
	}

	private List<Integer> validateNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String inputNumbers = Console.readLine();
		List<Integer> numbers = Arrays.stream(inputNumbers.split(",")).map(Integer::parseInt).toList();
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("6개의 정수를 입력해야 합니다.");
		}
		if (duplicateNumber(numbers)) {
			throw new IllegalArgumentException("숫자가 중복 됐습니다.");
		}
		for (int number : numbers) {
			if (number > 45 || number < 1) {
				throw new IllegalArgumentException("1에서 45 사이의 정수를 입력해야 합니다.");
			}
		}
		return numbers;
	}

	private boolean duplicateNumber(List<Integer> numbers) {
		if (numbers.size() != numbers.stream().distinct().count()) {
			return true;
		}
		return false;
	}

	public List<Integer> readNumbers() {
		while (true) {
			try {
				List<Integer> numbers = validateNumbers();
				return numbers;
			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 유효한 정수를 입력하세요.");
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 1에서 45사이의 정수를 중복되지 않게 6개 입력하세요.");
			}
		}
	}

	public int readBonusNumbers() {
		while (true) {
			try {
				int number = validateBonusNumbers();
				return number;
			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 유효한 정수를 입력하세요.");
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 1에서 45사이의 정수를 당첨 번호와 중복되지 않게 입력하세요.");
			}
		}
	}

	private int validateBonusNumbers() {
		System.out.println("보너스 번호를 입력해 주세요.");
		int number = Integer.parseInt(Console.readLine());
		if (number > 45 || number < 1) {
			throw new IllegalArgumentException("1에서 45 사이의 정수를 입력해야 합니다.");
		}
		if (numbers.contains(number)) {
			throw new IllegalArgumentException("당첨 번호와 중복 됐습니다.");
		}
		return number;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}
