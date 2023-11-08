package lotto.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoWinner;

public class Input {

	public static final String COMMA_DELIMITER = ",";

	public static int purchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return toInteger(Console.readLine());
	}

	public static List<Integer> winningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		return toIntegerList(Console.readLine());
	}

	public static int bonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		return toInteger(Console.readLine());
	}

	private static List<Integer> toIntegerList(String str) {
		if (str == null) {
			throw new IllegalArgumentException("올바른 입력이 아닙니다.");
		}
		List<Integer> integers = Arrays.stream(str.split(COMMA_DELIMITER))
			.map(Input::toInteger)
			.toList();
		if (integers.size() != LottoWinner.SIZE) {
			throw new IllegalArgumentException("입력된 당첨 번호의 개수가 올바르지 않습니다.");
		}
		return integers;
	}

	private static int toInteger(String str) {
		if (isNumeric(str) && Integer.parseInt(str) > 0) {
			return Integer.parseInt(str);
		}
		throw new IllegalArgumentException("숫자로 변환할 수 없습니다.");
	}

	private static boolean isNumeric(String str) {
		return str != null && str.matches("[0-9.]+");
	}
}
