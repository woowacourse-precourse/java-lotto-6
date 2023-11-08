package lotto.model.constant;

public enum WinningCaseCountConstantEnum {
	WINNING_MIN_COUNT(3),
	INITIALIZE_COUNT(0);
	private final int value;


	WinningCaseCountConstantEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}


}
