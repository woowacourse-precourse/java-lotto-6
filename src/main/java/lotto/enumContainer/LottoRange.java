package lotto.enumContainer;

public enum LottoRange {

	START(1),
	END(45);

	private int number;

	LottoRange(int number) {
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}


}
