package lotto.enumContainer;

public enum RelateToLotto {

	START(1),
	END(45),
	COUNT(6),
	MINIMUM_MONEY(1000);

	private int number;

	RelateToLotto(int number) {
		this.number = number;
	}

	public int number() {
		return this.number;
	}


}
