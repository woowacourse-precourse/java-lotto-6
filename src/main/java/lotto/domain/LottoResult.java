package lotto.domain;

import java.util.Arrays;
import lotto.domain.vo.Money;

public enum LottoResult {
	LOSING_TICKET(0, 0, false, 0),
	FIFTH(5000, 3, false, 0),
	FORTH(50000, 4, false, 0),
	THIRD(1500000, 5, false, 0),
	SECOND(30000000, 5, true, 0),
	FIRST(2000000000, 6, false, 0);

	private final int reward;
	private final int matchAmount;
	private final boolean bonusStatus;
	private int winningAmount;

	LottoResult(int reward, int matchAmount, boolean bonusStatus, int winningAmount) {
		this.reward = reward;
		this.matchAmount = matchAmount;
		this.bonusStatus = bonusStatus;
		this.winningAmount = winningAmount;
	}

	public static void setResult(int amount, boolean status) {
		setAmount(
				Arrays.stream(LottoResult.values())
						.filter(each -> each.matchAmount == amount && each.bonusStatus == status)
						.findAny()
						.orElse(LOSING_TICKET)
		);
	}

	public static Money getIncome() {
		return new Money(
				Arrays.stream(LottoResult.values())
						.mapToInt(each -> each.reward * each.winningAmount)
						.sum()
		);
	}

	public static String generateResultContent() {
		StringBuilder stringBuilder = new StringBuilder();
		Arrays.stream(LottoResult.values())
				.filter(each -> each != LottoResult.LOSING_TICKET)
				.map(each -> String.format("%,d개 일치%s (%,d원) - %,d개%n",
						each.matchAmount,
						getBonusStatus(each.bonusStatus),
						each.reward,
						each.winningAmount))
				.forEach(stringBuilder::append);
		return stringBuilder.toString();
	}

	private static String getBonusStatus(boolean value) {
		if (value) {
			return ", 보너스 볼 일치";
		}
		return "";
	}

	private static void setAmount(LottoResult rewards) {
		rewards.winningAmount++;
	}
}