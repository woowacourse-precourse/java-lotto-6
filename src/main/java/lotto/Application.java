package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static final int WINNING_NUMBER_LENGTH = 6;

	private static Integer money;
	private static List<Integer> winningNumberList;
	private static Integer bonusNumber;

	public static void main(String[] args) {
		setMoney();
		setWinningNumberList();
		setBonusNumber();
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
			winningNumberList = readNumberList(WINNING_NUMBER_LENGTH);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setWinningNumberList();
		}
	}

	public static void setBonusNumber() {
		try {
			System.out.println("보너스 번호를 입력해 주세요.");
			bonusNumber = readNumber();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setBonusNumber();
		}
	}

	private static Integer readNumber() {
		Integer number = null;
		try {
			number = Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다!");
		}
		return number;
	}

	private static List<Integer> readNumberList(int size) {
		List<Integer> numberList = new ArrayList<>();
		try {
			String[] inputList = Console.readLine().split(",");

			if (inputList.length != size) {
				throw new IllegalArgumentException("[ERROR] " + size + "개를 입력해야 합니다!");
			}

			for (String input : inputList) {
				Integer number = Integer.parseInt(input);
				numberList.add(number);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다!");
		}
		return numberList;
	}
}
