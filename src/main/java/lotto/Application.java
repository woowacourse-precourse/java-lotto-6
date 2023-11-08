package lotto;

import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.Input;

public class Application {
	private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String BUY_QUANTITY_MESSAGE = "%d개를 구매했습니다.\n";
	private static final String INPUT_WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
	private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
	private static final String LINE = "---";
	private static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5,000원) - %d개\n";
	private static final String FOURTH_PRIZE_MESSAGE = "4개 일치 (50,000원) - %d개\n";
	private static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
	private static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
	private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
	private static final String TOTAL_RETURN_RATE = "총 수익률은 %.1f%%입니다.\n";

	public static void main(String[] args) {
		System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
		final var amount = Input.readPurchaseAmount();
		final var lottoSeller = new LottoSeller();
		final var lottos = lottoSeller.sellLotto(amount);
		System.out.printf(BUY_QUANTITY_MESSAGE, lottos.size());
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}

		System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
		final var winningNumbers = Input.readWinningNumbers();

		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		final var bonusNumber = Input.readBonusNumbers();

		WinningResult.calculateResult(lottos, new Lotto(winningNumbers), bonusNumber);

	}
}
