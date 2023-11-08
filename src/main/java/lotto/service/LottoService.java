package lotto.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.domain.UserLotto;
import lotto.dto.requset.WinningBonusNumber;
import lotto.dto.response.LottoCollection;
import lotto.dto.response.LottoNumber;
import lotto.dto.response.WinningResult;
import lotto.view.GameNumber;

public class LottoService implements Calculation{

	UserLotto userLotto = new UserLotto();

	@Override
	public LottoCollection createLotto(String price) {
		userLotto.setLotto(price);
		LottoCollection lottoCollection = new LottoCollection();
		lottoCollection.setLottoCount(userLotto.getLottoCount());
		for(Lotto lotto : userLotto.getAllLotto()){
			LottoNumber lottoNumber = new LottoNumber(lotto.getNumbers());
			lottoCollection.addLottoCollection(lottoNumber);
		}
		return lottoCollection;
	}

	@Override
	public WinningResult winningCalculation(WinningBonusNumber winningBonusNumber) {
		String winningNumber = winningBonusNumber.getWinningNumber();
		String bonusNumber = winningBonusNumber.getBonusNumber();
		List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
		List<Integer> winningNumbers = parseNumbers(winningNumber);
		int bonus = Integer.parseInt(bonusNumber);
		for (Lotto lotto : userLotto.getAllLotto()) {
			calculateAllCorrectCount(result, winningNumbers, bonus, lotto);
		}
		int totalPrize = calculateTotalWinnings(result);
		double profitMargin = calculateMargin(totalPrize);
		WinningResult winningResult = new WinningResult(result, profitMargin);
		return winningResult;
	}

	private static void calculateAllCorrectCount(List<Integer> result, List<Integer> winningNumbers, int bonus,
		Lotto lotto) {
		List<Integer> userNumbers = lotto.getNumbers();
		int matchCount = 0;
		for (int userNumber : userNumbers) {
			matchCount = containsUserNumber(winningNumbers, matchCount, userNumber);
		}

		correctCount(result, bonus, userNumbers, matchCount);
	}

	private double calculateMargin(int totalPrize) {
		double profitMargin = ((double) (totalPrize - userLotto.getPrice()) / totalPrize) * 100.0;
		return profitMargin;
	}

	private static void correctCount(List<Integer> result, int bonus, List<Integer> userNumbers,
		int matchCount) {
		sixCorrectCount(result, matchCount);
		fiveCorrectBonusCount(result, bonus, userNumbers, matchCount);
		fiveCorrectCount(result, matchCount);
		fourCorrectCount(result, matchCount);
		threeCorrectCount(result, matchCount);
	}

	private static int containsUserNumber(List<Integer> winningNumbers, int matchCount, int userNumber) {
		if (winningNumbers.contains(userNumber)) {
			matchCount++;
		}
		return matchCount;
	}

	private static void sixCorrectCount(List<Integer> result, int matchCount) {
		if (matchCount == 6) {
			result.set(5, result.get(5) + 1); // 6개 일치 (2,000,000,000원)
		}
	}

	private static void fiveCorrectBonusCount(List<Integer> result, int bonus, List<Integer> userNumbers,
		int matchCount) {
		if (matchCount == 5 && userNumbers.contains(bonus)) {
			result.set(4, result.get(4) + 1); // 5개 + 보너스 숫자 일치 (30,000,000원)
		}
	}

	private static void fiveCorrectCount(List<Integer> result, int matchCount) {
		if (matchCount == 5) {
			result.set(3, result.get(3) + 1); // 5개 일치 (1,500,000원)
		}
	}

	private static void fourCorrectCount(List<Integer> result, int matchCount) {
		if (matchCount == 4) {
			result.set(2, result.get(2) + 1); // 4개 일치 (50,000원)
		}
	}

	private static void threeCorrectCount(List<Integer> result, int matchCount) {
		if (matchCount == 3) {
			result.set(1, result.get(1) + 1); // 3개 일치 (5,000원)
		}
	}

	public int calculateTotalWinnings(List<Integer> result) {
		int totalWinnings = 0;
		for (int i = 0; i < result.size(); i++) {
			int category = i + 1;
			int prize = calculatePrize(category); // 각 카테고리별 상금 계산
			int count = result.get(i); // 해당 카테고리의 당첨 횟수
			totalWinnings += prize * count;
		}
		return totalWinnings;
	}

	public int calculatePrize(int category) {
		int prize = 0;
		prize = threeCorrect(category, prize);
		prize = fourCorrect(category, prize);
		prize = fiveCorrect(category, prize);
		prize = fiveCorrectBonus(category, prize);
		prize = sixCorrect(category, prize);
		return prize;

	}

	private static int sixCorrect(int category, int prize) {
		if (category == 5) {
			prize = GameNumber.SIX_CORRECT_PRICE.getNum();
		}

		return prize;
	}

	private static int fiveCorrectBonus(int category, int prize) {
		if (category == 4) {
			prize = GameNumber.FIVE_CORRECT_BONUS_PRICE.getNum();
		}
		return prize;
	}

	private static int fiveCorrect(int category, int prize) {
		if (category == 3) {
			prize = GameNumber.FIVE_CORRECT_PRICE.getNum();
		}
		return prize;
	}

	private static int fourCorrect(int category, int prize) {
		if (category == 2) {
			prize = GameNumber.FOUR_CORRECT_PRICE.getNum();
		}
		return prize;
	}

	private static int threeCorrect(int category, int prize) {
		if (category == 1) {
			prize = GameNumber.THREE_CORRECT_PRICE.getNum();
		}
		return prize;
	}

	private List<Integer> parseNumbers(String numbersString) {
		List<Integer> numbers = new ArrayList<>();
		String[] numberStrings = numbersString.split(",");
		for (String numberStr : numberStrings) {
			numbers.add(Integer.parseInt(numberStr));
		}
		return numbers;
	}
}
