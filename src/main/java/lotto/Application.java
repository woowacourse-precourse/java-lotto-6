package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.generate.RandomGenerator;
import lotto.readInput.InputBonus;
import lotto.readInput.InputNumbers;
import lotto.readInput.InputPurchase;

public class Application {

	public static void main(String[] args) {

		int number = purchase();
		RandomGenerator generator = generate(number);
		List<Integer> winningNumbers = winningNumbers();
		int bonus = bonus(winningNumbers);

		result(winningNumbers, generator, bonus, number);
	}

	public static int purchase() {
		System.out.println(InputMessage.INPUT_PURCHASE.getMessage());
		int number = InputPurchase.purchaseAmount();
		return number;
	}

	public static RandomGenerator generate(int number) {
		RandomGenerator generator = new RandomGenerator(number / 1000);
		generator.print();
		return generator;
	}

	public static List<Integer> winningNumbers() {
		System.out.println("\n" + InputMessage.INPUT_WINNINGNUMBERS.getMessage());
		List<Integer> winningNumbers = new ArrayList<>();
		winningNumbers = InputNumbers.winningNumbers();
		return winningNumbers;
	}

	public static int bonus(List<Integer> winningNumbers) {
		System.out.println("\n" + InputMessage.INPUT_BONUS.getMessage());
		int bonus = InputBonus.bonusNumber(winningNumbers);
		return bonus;
	}

	public static void result(List<Integer> winningNumbers, RandomGenerator generator, int bonus, int number) {
		Lotto lotto = new Lotto(winningNumbers);
		List<Integer> result = new ArrayList<>();
		result = lotto.compare(generator.myLotto, bonus);
		lotto.printResult(result);
		lotto.rateOfReturn(result, number);
	}
}