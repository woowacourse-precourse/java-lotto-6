package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

	static List<Lotto> lottos = new ArrayList<>();
	static List<Integer> newLottos = new ArrayList<>();

	static List<Integer> countResult = new ArrayList<>();
	static int bonus, count;
	static private int seedMoney;

	public static void main(String[] args) {
		inputSeedMoney();
		pickRandomNumber();
		printStatus();
		pickLottoNumber();
		pickBonusNumber();
		printResult();
	}

	private static void inputSeedMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		seedMoney = Integer.parseInt(readLine());
		if (seedMoney % 1000 != 0) {
			throw new ArithmeticException("1,000원 단위로 입력해주세요.");
		}
		System.out.println();
		System.out.println(seedMoney % 1000 + "개를 구매했습니다.");
	}

	private static void pickRandomNumber() {
		for (int i = 0; i < seedMoney / 1000; i++) {
			lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
		}
	}

	public static void printStatus() {
		lottos.forEach(lotto -> System.out.println(lotto));
	}

	public static void pickLottoNumber() {
		System.out.println("담청 번호를 입력해 주세요.");
		String input = readLine().trim();
		for (String lottoNumber : input.split(",")) {
			newLottos.add(Integer.parseInt(lottoNumber));
		}
	}

	public static void pickBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		bonus = Integer.parseInt(readLine());
	}

	public static void printResult() {
		getWinningNumbers();
		getCountNumber();
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + countResult.get(0));
		System.out.println("4개 일치 (50,000원) - " + countResult.get(1));
		System.out.println("5개 일치 (1,500,000원) - " + countResult.get(2));
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countResult.get(3));
		System.out.println("6개 일치 (2,000,000,000원) - " + countResult.get(4));
		int finalResult = 0;
		for (int i = 0; i < countResult.size(); i++) {
			int profit = 0;
			profit += countResult.get(i);
			finalResult = (profit / seedMoney) * 100;
		}
		System.out.println("총 수익률은 " + finalResult + "입니다.");
	}

	public static void getWinningNumbers() {
		for (int i = 0; i < lottos.size(); i++) {
			count = 0;
			for (int j = 0; j < newLottos.size(); j++) {
				if (lottos.contains(newLottos.get(j))) {
					count++;
				}
			}
		}
	}

	public static void getCountNumber() {
		if (count == 3) {
			int result = 0;
			result++;
			countResult.add(result);
		}
		if (count == 4) {
			int result = 0;
			result++;
			countResult.add(result);
		}
		if (count == 5) {
			int result = 0;
			result++;
			if (lottos.contains(bonus)) {
				countResult.add(result);
			}
			if (!lottos.contains(bonus)) {
				countResult.add(result);
			}
		}
		if (count == 6) {
			int result = 0;
			result++;
			countResult.add(result);
		}

	}

}
