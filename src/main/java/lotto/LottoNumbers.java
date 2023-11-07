package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoNumbers {
	public static double earningsRate = 0;
	public Map<Integer, Integer> result = new HashMap<>();
	private static double totalAmount;
	private static int bonusNum;
	private static int bonusCount;
	private boolean bonus;

	private static List<Integer> inputNum;
	private static List<List> randomNumbers;

	public LottoNumbers(List<Integer> inputNum, List<List> randomNum, int totalAmount, int bonus) {
		this.inputNum = inputNum;
		this.randomNumbers = randomNum;
		this.totalAmount = Double.valueOf(totalAmount);
		this.bonusNum = bonus;
	}

	public void run() {
		result.put(7, 0);
		for (int i = 0; i < randomNumbers.size(); i++) {
			bonus = false;

			Lotto lotto = new Lotto(randomNumbers.get(i));
			int cnt = lotto.matchNumber(inputNum);

			if (cnt == 5) {
				bonus = lotto.isBonus(bonusNum);
				setBonus(bonus);
			}

			if (result.containsKey(cnt) == false && bonus == false)
				result.put(cnt, 0);

			setRanking(cnt);
		}
		missOrNot();

		WinningResult winning = new WinningResult(earningsRate, result);
		winning.printingResult();
	}

	private void setRanking(int num) {
		if (bonus == false) {
			int plusNum = result.get(num) + 1;
			result.replace(num, plusNum);
		}
	}

	private void setBonus(boolean b) {
		if (b == true)
			bonusCount++;
		result.replace(7, bonusCount);
	}

	private void missOrNot() {
		int miss = 0;
		for (int m = 0; m < 3; m++) {
			if (result.containsKey(m) != false)
				miss += result.get(m);
		}

		if (miss != randomNumbers.size())
			calRate();
	}

	private void calRate() {
		int prize = 0;
		int price = 0;

		for (int j = 3; j <= 6; j++) {
			price = Ranking.getWinningAmount(j);

			if (result.containsKey(j) != false)
				prize += result.get(j) * price;
		}

		if (bonusCount != 0)
			prize += bonusCount * Ranking.getWinningAmount(7);

		earningsRate = Double.valueOf(prize) / totalAmount;
	}
}