package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {
	public static void printLottoAmount(int amount) {
		System.out.println(amount + "개를 구매했습니다.");
	}

	public static void printLottoNumbers(Lotto lottoNumber) {
		System.out.println(lottoNumber.getNumbers());
	}

	public static void printResult() {
		System.out.println("당첨 통계");
		System.out.println("---");
	}


	public static void printPrizeResult(Map<Prize, Integer> prizeCount, long totalPrizeMoney, int amount) {
		int chk = 0;
		for (Prize prize : Prize.values()) {
			if (prize.getPrizeMoney() > 0 && chk != 4) {
				System.out.printf("%d개 일치 (%s원) - %d개%n",
						prize.getCount(),
						String.format("%,d", prize.getPrizeMoney()),
						prizeCount.get(prize));
			}
			if (prize.getPrizeMoney() > 0 && chk == 4) {
				System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
						prize.getCount(),
						String.format("%,d", prize.getPrizeMoney()),
						prizeCount.get(prize));
			}
			chk++;
		}
		double rate = (double) totalPrizeMoney / amount / 10;
		System.out.println("총 수익률은 " + String.format("%,.1f", rate) + "%입니다.");
	}
}
