package lotto.view;

import lotto.global.util.Constants;
import lotto.model.Lotto;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
	public void printPriceInputMessage() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public void printNumbersInputMessage() {
		System.out.println("당첨 번호를 입력해 주세요.");
	}

	public void printBonusNumberInputMessage() {
		System.out.println("보너스 번호를 입력해 주세요.");
	}

	public void printErrorMessage(RuntimeException ex) {
		System.out.printf("[ERROR] %s\n", ex);
	}

	public void printLottos(List<Lotto> lottos) {
		System.out.printf("%d개를 구매했습니다.\n", Constants.LOTTO_COUNT.value);
		lottos.forEach(it -> System.out.println(it.getNumbers()));
	}

	public void printResult(int matchCount, int count) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		System.out.printf("%d개 일치 (%s원) - %d개\n", matchCount, decimalFormat.format(getMoney(matchCount)), count);
	}

	public void printBonusResult(int count) {
		System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", count);
	}

	public void printReturnRate(double returnRate) {
		System.out.printf("총 수익률은 %.1f%%입니다.", returnRate);
	}

	private int getMoney(int matchCount) {
		if (matchCount == 3) return 5000;
		if (matchCount == 4) return 50000;
		if (matchCount == 5) return 1500000;
		if (matchCount == 6) return 2000000000;
		return 0;
	}
}