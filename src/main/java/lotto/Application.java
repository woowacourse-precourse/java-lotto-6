package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		startGame();
	}

	public static void startGame() {
		int puarchaseAmount = purchaseAmount();
		int lottoCount = getLottoCount(puarchaseAmount);
		List<Lotto> lottos = getRandomLottos(lottoCount);

		List<Integer> lottoNumbers = lottoNumbers();
		int bonusNumber = bonusNumber();

		Map<LottoResult, Integer> results = calculateResults(lottos, lottoNumbers, bonusNumber);
		printResults(results, puarchaseAmount);
	}

	public static int purchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		String amountInput = Console.readLine();
		try {
			int amount = Integer.parseInt(amountInput);
			if (amount % 1000 != 0) {
				throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
			}
			return amount;
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] 유효한 숫자가 아닙니다.");
			return purchaseAmount();
		}
	}

	public static int getLottoCount(int puarchaseAmount) {
		return puarchaseAmount / 1000;
	}

	public static List<Lotto> getRandomLottos(int lottoCount) {
		System.out.println("\n" + lottoCount + "개를 구매했습니다.");
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			Lotto lotto = Lotto.randomLotto();
			System.out.println(lotto.getNumbers());
			lottos.add(lotto);
		}
		return lottos;
	}

	public static List<Integer> lottoNumbers() {
		System.out.println("\n당첨 번호를 입력해 주세요.");
		String lottoNumbersInput = Console.readLine();
		String[] lottoNumbersArray = lottoNumbersInput.split(",");
		List<Integer> lottoNumbersList = new ArrayList<>();
		for (int i = 0; i < lottoNumbersArray.length; i++) {
			if (lottoNumbersArray[i].length() < 6) {
				lottoNumbersList.add(Integer.parseInt(lottoNumbersArray[i]));
			}
		}
		return lottoNumbersList;
	}

	public static int bonusNumber() {
		System.out.println("\n보너스 번호를 입력해 주세요.");
		String bonusNumberInput = Console.readLine();
		int bonusNumber = Integer.parseInt(bonusNumberInput);
		return bonusNumber;
	}

	public static Map<LottoResult, Integer> calculateResults(List<Lotto> purchasedLottos, List<Integer> lottoNumbers, int bonusNumber) {
		Map<LottoResult, Integer> results = new EnumMap<>(LottoResult.class);
		for (Lotto lotto : purchasedLottos) {
			long matchingCount = lotto.compareNumbers(lottoNumbers);
			if (matchingCount == 6) putResult(results, LottoResult.SIX_ACCORD);
			if (matchingCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
				putResult(results, LottoResult.FIVE_AND_BONERCE_ACCORD);
			}
			if (matchingCount == 5) putResult(results, LottoResult.FIVE_ACCORD);
			if (matchingCount == 4) putResult(results, LottoResult.FOUR_ACCORD);
			if (matchingCount == 3) putResult(results, LottoResult.THREE_ACCORD);
		}
		return results;
	}

	private static void putResult(Map<LottoResult, Integer> results, LottoResult lottoResult) {
		Integer cnt = results.get(lottoResult);
		if (cnt == null) cnt = 0;
		results.put(lottoResult, cnt =+ 1);
	}

	public static void printResults(Map<LottoResult, Integer> results, int amount) {
		System.out.println("results : "+ results);
		System.out.println("\n당첨 통계");
		System.out.println("---");
		System.out.println(LottoResult.THREE_ACCORD.getResult(results));
		System.out.println(LottoResult.FOUR_ACCORD.getResult(results));
		System.out.println(LottoResult.FIVE_ACCORD.getResult(results));
		System.out.println(LottoResult.FIVE_AND_BONERCE_ACCORD.getResult(results));
		System.out.println(LottoResult.SIX_ACCORD.getResult(results));

		double totalWinningAmount = LottoResult.getTotalPriceResult(results);
		double profitRate = ((totalWinningAmount) / amount) * 100;
		System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
	}
}

