package lotto.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

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
		return Arrays.stream(str.split(COMMA_DELIMITER))
			.map(Input::toInteger)
			.toList();
	}

	private static int toInteger(String str) {
		if (isNumeric(str)) {
			return Integer.parseInt(str);
		}
		throw new IllegalArgumentException("숫자로 변환할 수 없습니다.");
	}

	private static boolean isNumeric(String str) {
		return str != null && str.matches("[0-9.]+");
	}
}
