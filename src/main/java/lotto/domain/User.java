package lotto.domain;

public class User {
	private Integer money;
	private LottoPaper lottoPaper;

	public User(Integer money) {
		this.money = money;
		validate();
		this.lottoPaper = new LottoPaper(money);
	}

	public void validate() {
		if (this.money % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력 가능합니다!");
		}
	}

	public LottoPaper getLottoPaper() {
		return this.lottoPaper;
	}

	public Integer getMoney() {
		return this.money;
	}
}
