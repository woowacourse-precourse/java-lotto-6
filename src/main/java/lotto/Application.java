package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {
		startGame();
	}

	public static void startGame() {
		int purchaseAmount = purchaseAmount();
		List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
		List<Lotto> Lottos = purchasedLottos(purchasedLottos);

		List<Integer> lottoNumbers = lottoNumbers();
		int bonusNumber = bonusNumber();

		int[] results = calculateResults(purchasedLottos, lottoNumbers, bonusNumber);
		printResults(results, purchaseAmount);
	}

	public static int purchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		String amountInput = Console.readLine();
//		if (!amountInput.matches("^\\d+$")) {
//			throw new IllegalArgumentException("[ERROR] 유효한 숫자가 아닙니다.");
//		}
		int amount = Integer.parseInt(amountInput);
		if (amount % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
		}
		return amount;
	}

	public static List<Lotto> purchaseLottos(int purchaseAmount) {
		int lottoCount = purchaseAmount / 1000;
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			Lotto lotto = Lotto.randomLotto();
			System.out.println("lotto" + lotto);
			lottos.add(lotto);
		}
		return lottos;
	}

	public static List<Lotto> purchasedLottos(List<Lotto> lottos) {
		System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
		for(Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers());
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

	public static int[] calculateResults(List<Lotto> purchasedLottos, List<Integer> lottoNumbers, int bonusNumber) {
		int[] results = new int[6]; // 0개 일치부터 5개 일치까지 당첨된 횟수를 저장
		for (Lotto lotto : purchasedLottos) {
			int matchingCount = lotto.compareNumbers(lottoNumbers);
			if (matchingCount == 6) {
				results[1]++; // 6개 일치
			}
			if (matchingCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
				results[5]++;
			}
			if (matchingCount == 5) {
				results[4]++;
			}
			if (matchingCount == 4) {
				results[3]++;
			}
			if (matchingCount == 3) {
				results[2]++;
			}
		}
		return results;
	}

	public static void printResults(int[] results, int amount) {
		System.out.println("\n당첨 통계");
		System.out.println("---");
		System.out.printf("3개 일치 (5,000원) - %d개\n", results[2]);
		System.out.printf("4개 일치 (50,000원) - %d개\n", results[3]);
		System.out.printf("5개 일치 (1,500,000원) - %d개\n", results[4]);
		System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", results[5]);
		System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", results[1]);
		double totalWinningAmount = results[2] * 5000 + results[3] * 50000 + results[4] * 1500000 + results[5] * 30000000 + results[1] * 2000000000;
		double profitRate = ((totalWinningAmount) / amount) * 100;
		System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
	}
}

