package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoView {
	public int getMoney() { // 사용자의 금액 입력을 받는 메서드
		while (true) {
			try {
				System.out.println("구입 금액을 입력해주세요.");
				int userInput = Integer.parseInt(readLine().trim()); // 사용자의 입력을 받는다
				this.validateMoney(userInput); // 사용자의 입력값에 대한 유효성 검사를 실행한다
				System.out.printf("%n%s개를 구매했습니다 %n", userInput / 1000); // 사용자가 구매한 갯수를 알려준다.
				return userInput / 1000;
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] 금액은 숫자만 입력이 가능합니다.");
			} catch (IllegalStateException e) {
				System.err.println("[ERROR] 금액은 천원으로 나누어 떨어져야합니다.");
			}
		}
	}

	private void validateMoney(int input) { // 사용자가 입력한 값이 1000으로 나누어 떨어지는지 예외처리
		if (input % 1000 != 0) {
			throw new IllegalStateException();
		}
	}

	public void printLottos(List<Integer> numbers) {
		System.out.println(numbers);
	}

	public String[] getWinLotto() { // 사용자의 당첨번호를 입력받는 메서드
		while (true) {
			try {
				System.out.printf("%n당첨번호를 입력해 주세요.%n");
				String[] userInput = (readLine().trim()).split(","); // 사용자의 입력을 받는다
				this.validateNumber(userInput); // 사용자의 입력값에 대한 유효성 검사를 실행한다
				return userInput;
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] 번호는 숫자로 입력해주세요.");
			} catch (IllegalArgumentException e) {
				System.err.println("[ERROR] 콤마(,)로 구분하여 입력해주세요.");
			} catch (IllegalStateException e) {
				System.err.println("[ERROR]1~45사이의 번호를 중복되지 않게 6개 입력해주세요.");
			}
		}
	}

	private void validateNumber(String[] input) {
		Set<Integer> numbers = new HashSet<>();
		if (input.length != 6) {
			throw new IllegalStateException();
		}
		for (String numStr : input) {
			int num;
			num = Integer.parseInt(numStr);
			if (num < 1 || num > 45 || !numbers.add(num)) {
				throw new IllegalStateException();
			}
		}

	}

	public int getBonusNumber() {
		while (true) {
			try {
				System.out.printf("%n보너스 번호를 입력해 주세요.%n");
				int userInput = Integer.parseInt(readLine().trim());
				this.validateNumberRange(userInput);
				return userInput;
			} catch (NumberFormatException e) {
				System.err.println("[ERROR] 번호는 숫자로 입력해주세요.");
			} catch (IllegalStateException e) {
				System.err.println("[ERROR] 번호는 1~45 사이의 숫자로 입력해주세요.");
			}
		}
	}

	private void validateNumberRange(int input) {
		if (input < 1 || input > 45) {
			throw new IllegalStateException();
		}
	}
}