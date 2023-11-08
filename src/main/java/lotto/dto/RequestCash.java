package lotto.dto;

public record RequestCash(
	Integer depositAmount,
	Integer spendAmount
) {

	private static final Integer INIT_AMOUNT = 0;

	public static RequestCash of(final Integer depositAmount) {
		return new RequestCash(depositAmount, INIT_AMOUNT);
	}

}
