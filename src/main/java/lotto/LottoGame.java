package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
	static final int MONEY_UNIT = 1000;

	public void start() {
		int money = readMoney();
		List<Lotto> lottos = makeLottos(money);
		showLottos(lottos);
		Winner winner = new Winner();
		new Result(lottos, winner, money);
	}

	private void showLottos(List<Lotto> lottos) {
		System.out.println(lottos.size() + "개를 구매했습니다.");
		for (Lotto lotto : lottos) {
			lotto.show();
		}
	}

	private List<Lotto> makeLottos(int money) {
		List<Lotto> lottos = new ArrayList<>();
		int loop = money / MONEY_UNIT;
		for (int i = 0; i < loop; i++) {
			lottos.add(Lotto.createLotto());
		}
		return lottos;
	}

	public int validateMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		int money = Integer.parseInt(Console.readLine());

		if (money % MONEY_UNIT != 0) {
			throw new IllegalArgumentException();
		}
		return money;
	}

	public int readMoney() {
		int money;
		while (true) {
			try {
				money = validateMoney();
				break;
			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 유효한 정수를 입력하세요.");
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 1000원 단위가 아닙니다.");
			}
		}
		return money;
	}
}