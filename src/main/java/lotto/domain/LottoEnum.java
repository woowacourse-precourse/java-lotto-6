package lotto.domain;

public enum LottoEnum {
	LOTTO_PRICE(1000), FIRST(2000000000), SECOND(30000000), THIRD(1500000), FOURTH(50000), FIFTH(5000);

	private final int money;

	LottoEnum(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}
}
