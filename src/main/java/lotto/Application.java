package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static final int WINNING_NUMBER_LENGTH = 6;
	public static final int LOTTO_MIN_NUMBER = 1;
	public static final int LOTTO_MAX_NUMBER = 45;

	private static Integer money;
	private static List<Integer> winningNumberList;
	private static Integer bonusNumber;
	private static List<Lotto> lottoList = new ArrayList<>();
	private static LottoResult[] resultCheckList = {
			LottoResult.THREE,
			LottoResult.FOUR,
			LottoResult.FIVE,
			LottoResult.FIVE_BONUS,
			LottoResult.SIX
	};

	public static void main(String[] args) {
		setMoney();
		setLottoList();
		setWinningNumberList();
		setBonusNumber();
		printResult();
	}

	private static void setMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			money = readNumber();

			if (money % 1000 != 0) {
				throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력 가능합니다!");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setMoney();
		}
	}

	public static void setWinningNumberList() {
		try {
			System.out.println("당첨 번호를 입력해 주세요.");
			winningNumberList = readNumberList(WINNING_NUMBER_LENGTH);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setWinningNumberList();
		}
	}

	public static void setBonusNumber() {
		try {
			System.out.println("보너스 번호를 입력해 주세요.");
			bonusNumber = readNumber();

			if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
				throw new IllegalArgumentException("[ERROR] 1-45 사이의 숫자만 입력할 수 없습니다!");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			setBonusNumber();
		}
	}

	private static Integer readNumber() {
		Integer number = null;
		try {
			number = Integer.parseInt(Console.readLine());

		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다!");
		}
		return number;
	}

	private static List<Integer> readNumberList(int size) {
		List<Integer> numberList = new ArrayList<>();
		try {
			String[] inputList = Console.readLine().split(",");

			if (inputList.length != size) {
				throw new IllegalArgumentException("[ERROR] " + size + "개를 입력해야 합니다!");
			}

			for (String input : inputList) {
				Integer number = Integer.parseInt(input);

				if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
					throw new IllegalArgumentException("[ERROR] 1-45 사이의 숫자만 입력할 수 없습니다!");
				}

				if (numberList.contains(number)) {
					throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다!");
				}

				numberList.add(number);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다!");
		}
		return numberList;
	}

	public static void setLottoList() {
		Integer lottoCount = money / 1000;
		System.out.println(lottoCount + "개를 구매했습니다.");
		for (int i = 0; i < lottoCount; i++) {
			Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, WINNING_NUMBER_LENGTH));
			System.out.println(lotto);
			lottoList.add(lotto);
		}
	}

	public static void printResult() {
		Double resultMoney = 0.0;
		System.out.println("당첨 통계");
		System.out.println("---");
		for (Lotto lotto : lottoList) {
			lotto.setResult(winningNumberList, bonusNumber);
		}

		for (LottoResult result : resultCheckList) {
			int count = 0;
			for (Lotto lotto : lottoList) {
				if (result.equals(lotto.getResult())) {
					count++;
				}
			}
			System.out.println(result.message + " - " + count + "개");
			resultMoney += result.money * count;
		}
		System.out.printf("총 수익률은 %.1f%%입니다.%n", resultMoney / money * 100);
	}
}
