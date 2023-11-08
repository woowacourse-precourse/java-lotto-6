package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

	static List<Lotto> lottos = new ArrayList<>();
	static List<Integer> newLottos = new ArrayList<>();
	static List<Integer> countResult = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

	static HashMap<Integer, Integer> map = new HashMap<>();
	static int bonus;
	static double profit = 0.0;
	static private int seedMoney;

	public static void main(String[] args) {
		inputSeedMoney();
		pickRandomNumber();
		printStatus();
		pickLottoNumber();
		pickBonusNumber();
		resetMap();
		printResult();
	}

	private static void inputSeedMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		seedMoney = Integer.parseInt(readLine());
		if (seedMoney % 1000 != 0) {
			throw new ArithmeticException("1,000원 단위로 입력해주세요.");
		}
		System.out.println();
		System.out.println(seedMoney / 1000 + "개를 구매했습니다.");
	}

	private static void pickRandomNumber() {
		for (int i = 0; i < seedMoney / 1000; i++) {
			lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
		}
	}

	public static void printStatus() {
		lottos.forEach(lotto -> System.out.println(lotto));
		System.out.println();
	}

	public static void pickLottoNumber() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String input = readLine().trim();
		for (String lottoNumber : input.split(",")) {
			newLottos.add(Integer.parseInt(lottoNumber));
		}
		System.out.println();
	}

	public static void pickBonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		bonus = Integer.parseInt(readLine());
		System.out.println();
	}

	public static void printResult() {
		lottos.forEach(lotto -> {
			if (getLottoResult(lotto) == 3) {
				countResult.set(0, countResult.get(0) + 1);
			} else if (getLottoResult(lotto) == 4) {
				countResult.set(1, countResult.get(1) + 1);
			} else if (getLottoResult(lotto) == 5) {
				if (!isBonusNumber(lotto)) {
					countResult.set(2, countResult.get(2) + 1);
				} else {
					countResult.set(3, countResult.get(3) + 1);
				}
			} else if (getLottoResult(lotto) == 6) {
				countResult.set(4, countResult.get(4) + 1);
			}
		});

		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + countResult.get(0));
		System.out.println("4개 일치 (50,000원) - " + countResult.get(1));
		System.out.println("5개 일치 (1,500,000원) - " + countResult.get(2));
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + countResult.get(3));
		System.out.println("6개 일치 (2,000,000,000원) - " + countResult.get(4));

		for (int i = 0; i < countResult.size(); i++) {
			profit += countResult.get(i) * map.get(i).intValue();
		}

		System.out.printf("총 수익률은 %.1f%%입니다.%n", profit / seedMoney * 100);
	}

	public static Integer getLottoResult(Lotto lotto) {
		Integer count = 0;

		for (Integer number : lotto.getNumbers()) {
			if (newLottos.contains(number)) {
				count++;
			}
		}
		return count;
	}

	public static Boolean isBonusNumber(Lotto lotto) {
		return lotto.getNumbers().contains(bonus);
	}

	public static void resetMap() {
		map.put(0, 5000);
		map.put(1, 50000);
		map.put(2, 1500000);
		map.put(3, 30000000);
		map.put(4, 2000000000);
	}
}
