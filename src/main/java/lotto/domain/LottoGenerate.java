package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Application;
import lotto.object.Lotto;

public class LottoGenerate {
	private static final int LOTTOPRICE = LottoEnum.LOTTO_PRICE.getMoney();

	public static String moneyCheck(String money) {
		try {
			Application.purchaseAmount = Integer.parseInt(money);
			if (Application.purchaseAmount % LOTTOPRICE != 0) {
				throw new IllegalArgumentException();
			}
			Application.ticketNumber = Application.purchaseAmount / LOTTOPRICE;
			System.out.println(Application.ticketNumber + "개를 구매했습니다.");
			makeLotto();
			return (Application.ticketNumber + "개를 구매했습니다.");

		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 금액을 1000 단위의 숫자만 입력하세요.");
			LottoStart.buyLotto();
			return (Application.ticketNumber + "개를 구매했습니다.");
		}
	}

	public static void makeLotto() {
		List<Lotto> saveLotto = new ArrayList<Lotto>();

		for (int i = 0; i < Application.ticketNumber; i++) {
			// 로또 티켓 각 장마다 인스턴스 생성
			saveLotto.add(numberMaker());
		}
		Application.lottoGroup = saveLotto;
		printTicket();
	}

	public static Lotto numberMaker() {
		List<Integer> randomNumber = new ArrayList<Integer>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

		Collections.sort(randomNumber); // 오름차순으로 정렬
		Lotto randomLotto = new Lotto(randomNumber);
		return randomLotto;
	}

	public static void printTicket() {
		for (Lotto tmpObj : Application.lottoGroup) {
			System.out.println(tmpObj.getNumbers());
		}
	}
}
