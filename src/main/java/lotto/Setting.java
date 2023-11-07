package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Setting {
	private static List<Integer> inputNum;
	private static List<Integer> randomNumbers;
	private static List<List> tmp = new ArrayList<>();
	private static List<List> lottoNum;
	private static int bonus;
	private static int totalAmount;
	private static String[] numbers;

	public void ready() {
		System.out.println(Constants.INPUT_LOTTO_AMOUNT);
		validatePrice(Console.readLine());

		System.out.println(Constants.INPUT_LOTTO_NUMBER);
		String str = Console.readLine();
		
		if(str.charAt(str.length() - 1) == ',')
			throw new IllegalArgumentException(Constants.NUMBER_ERROR_MSG);
		
		numbers = str.split(",");
		inputNum = Arrays.asList(numbers).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		
		Lotto lotto = new Lotto(inputNum);
		lotto.validatNumber(inputNum);
		System.out.println();

		System.out.println(Constants.INPUT_BONUS_NUMBER);
		validateBonus(Console.readLine());
	}

	public List<List> makeLottoNumbers(int ticket) {
		System.out.println("\n" + ticket + Constants.TICKET_GUIDE_STR);
		do {
			randomNumbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_NUMBER, Constants.MAX_LOTTO_NUMBER, Constants.LIMIT_LOTTO_NUMBER);
			Collections.sort(randomNumbers);
			System.out.println(randomNumbers);

			tmp.add(randomNumbers);

			ticket--;
		} while (ticket != 0);

		System.out.println();
		return tmp;
	}

	private void validatePrice(String price) {
		double quotient = 0;
		int ticket = 0;

		Lotto.validateInput(price);
		Lotto.isDigit(price);
		quotient = Double.parseDouble(price) % 1000;

		if ((Integer.parseInt(price) < 1000) || (quotient != 0.0))
			throw new IllegalArgumentException(Constants.AMOUNT_ERROR_MSG);

		ticket = Integer.parseInt(price) / 1000;
		totalAmount = Integer.parseInt(price);
		lottoNum = makeLottoNumbers(ticket);
	}

	private void validateBonus(String num) {
		Lotto.validateInput(num);
		Lotto.isDigit(num);
		Lotto.validateRange(Integer.parseInt(num));

		if (inputNum.contains(Integer.parseInt(num)) == true)
			throw new IllegalArgumentException(Constants.BONUS_ERROR_MSG);
		bonus = Integer.parseInt(num);
	}
}