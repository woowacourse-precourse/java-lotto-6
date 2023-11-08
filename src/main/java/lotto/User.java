package lotto;

import lotto.exception.ErrorMessage;
import lotto.ui.Input;
import lotto.ui.Output;
import lotto.ui.SystemMessage;

public class User {

	private Integer money;
	private Lottos lottos;

	public static User newInstance() {
		return new User();
	}

	private User() {
	}

	public Integer payMoney() {
		while (true) {
			try {
				return askMoneyAmount();
			} catch (IllegalArgumentException e) {
				Output.output(e::getMessage);
			}
		}
	}

	private Integer askMoneyAmount() {
		try {
			money = Input.integer(SystemMessage::inputMoney);
			if (money % 1000 != 0) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT);
			}
			return money;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_UNIT);
		}
	}

	public void receiveLottos(Lottos lottos) {
		this.lottos = lottos;
	}

	public LottoResults matchLottos(Lotto answerLotto, Integer bonusNumber) {
		return lottos.matchLotto(answerLotto, bonusNumber);
	}

	public void calculatePrize(LottoResults lottoResults) {
		Output.output(SystemMessage::lottoStatistics);
		Integer revenue = lottoResults.calculateRevenue();
		Double revenueRate = (double) revenue / money * 100;
		Output.output(() -> SystemMessage.totalRevenueRate(revenueRate));
	}
}