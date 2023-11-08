package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static int calculateLottoCount(String strUserMoney) {

		int userMoney = Integer.parseInt(strUserMoney);

		int lottoCount = (userMoney / 1000);

		return lottoCount;

	}

	public static List<Integer> numbers() {
	    System.out.println();
	    System.out.println("당첨 번호를 입력해 주세요.");

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
		System.out.println("보너스 번호를 입력해 주세요.");

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

	public static String money() {

		System.out.println("구입금액을 입력해 주세요.");

		while (true) {
			String inputMoney = Console.readLine();
			try {
				CheckValid.money(inputMoney);
				return inputMoney;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
