package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
	private static final String INPUT_NUNBERS = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS = "보너스 번호를 입력해 주세요.";

	public static List<Integer> numbers() {

		System.out.println(INPUT_NUNBERS);

		while (true) {
			String inputNumber = Console.readLine();
			List<Integer> numbers = getValidNumbers(inputNumber);
			if (numbers != null) {
				return numbers;
			}
		}
	}

	private static List<Integer> getValidNumbers(String inputNumber) {
		String[] usernums = inputNumber.split(",");
		try {
			List<Integer> numbers = new ArrayList<>();
			for (String usernum : usernums) {
				CheckValid.string(usernum);
				numbers.add(Integer.parseInt(usernum));
			}
			CheckValid.numbers(numbers);
			return numbers;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static int bonus(List<Integer> userNums) {
		System.out.println();
		System.out.println(INPUT_BONUS);
		while (true) {
			String inputBonus = Console.readLine();
			try {
				CheckValid.string(inputBonus);
				int bonus = Integer.parseInt(inputBonus);
				CheckValid.bonus(userNums, bonus);
				return bonus;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int money() {

		System.out.println(INPUT_MONEY);

		while (true) {
			String inputMoney = Console.readLine();
			try {
				CheckValid.money(inputMoney);
				int userMoney = Integer.parseInt(inputMoney);
				return userMoney;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
