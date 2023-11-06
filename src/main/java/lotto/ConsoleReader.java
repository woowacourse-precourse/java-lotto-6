package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader {
	public static Integer readNumber() {
		Integer number = null;
		try {
			number = Integer.parseInt(Console.readLine());

		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다!");
		}
		return number;
	}

	public static List<Integer> readNumberList() {
		List<Integer> numberList = new ArrayList<>();
		try {
			for (String input : Console.readLine().split(",")) {
				Integer number = Integer.parseInt(input);
				numberList.add(number);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다!");
		}
		return numberList;
	}
}
