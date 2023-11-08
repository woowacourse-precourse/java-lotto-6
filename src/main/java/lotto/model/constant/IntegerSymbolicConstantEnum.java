package lotto.model.constant;

public enum IntegerSymbolicConstantEnum {
	MONEY_UNIT(1000),
	WANTED_REMAINDER(0),
	END_OF_COUNT(0),
	SIZE_OF_TICKET(6),
	INDEX_FOCUS_NUMBER(1),
	INDEX_PIVOT_STEP(1),
	FREQUENCY_MAX_VALUE(1),
	BONUS_FREQUENCY_MAX_VALUE(0),
	MIN_NUMBER_FOR_LOTTO_NUMBERS(1),
	MAX_NUMBER_FOR_LOTTO_NUMBERS(45),
	MAX_SIZE_FOR_LOTTO_NUMBERS(6),
	COUNT_STEP(1),
	START_OF_COUNT(0),
	END_OF_WINNING_CASE_COUNT(6),
	MATH_ROUND_SETTER(100);

	private final int value;
	IntegerSymbolicConstantEnum(int value) { this.value = value; }

	public int getValue() { return value; }
}
