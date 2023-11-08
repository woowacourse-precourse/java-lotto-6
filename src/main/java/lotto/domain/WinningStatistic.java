package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lotto.domain.vo.Money;

public class WinningStatistic {
	private final Money inputAmount;
	private final Money income;

	public WinningStatistic(Money inputAmount) {
		this.inputAmount = inputAmount;
		this.income = LottoResult.getIncome();
	}

	public double getIncomeRate() {
		return new BigDecimal(income.money())
				.divide(
						new BigDecimal(inputAmount.money()),
						3,
						RoundingMode.HALF_EVEN)
				.multiply(BigDecimal.valueOf(100))
				.doubleValue();
	}
}
