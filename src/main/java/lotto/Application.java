package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	private static Integer money;
	private static List<Integer> winningNumberList;

	public static void main(String[] args) {
		setMoney();
		setWinningNumberList();
	}

	private static void setMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			money = readNumber();

			if (money % 1000 != 0) {
				throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력 가능합니다!");
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setMoney();
		}
	}

	public static void setWinningNumberList() {
		try {
			System.out.println("당첨 번호를 입력해 주세요.");
			winningNumberList = readNumberList();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setWinningNumberList();
		}
	}

	private static Integer readNumber() {
		Integer number = null;
		try {
			number = Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력 가능합니다!");
		}
		return number;
	}

	private static List<Integer> readNumberList() {
		List<Integer> numberList = new ArrayList<>();
		try {
			String[] inputList = Console.readLine().split(",");

			if (inputList.length != 6) {
				throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다!");
			}

			for (String input : inputList) {
				Integer number = Integer.parseInt(input);
				numberList.add(number);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다!");
		}
		return numberList;
	}
}
