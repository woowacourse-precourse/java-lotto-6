package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

	static private int seedMoney;

	public static void main(String[] args) {
		inputSeedMoney();
		pickRandomNumber();
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
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < seedMoney / 1000; i++) {
			lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
		}
	}


}
