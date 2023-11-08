package lotto.view;

public enum GameNumber {

	THREE_CORRECT_PRICE(5000),
	FOUR_CORRECT_PRICE(50000),
	FIVE_CORRECT_PRICE(1500000),
	FIVE_CORRECT_BONUS_PRICE(30000000),
	SIX_CORRECT_PRICE(2000000000),
	THREE_CORRECT_INDEX(0),
	FOUR_CORRECT_INDEX(1),
	FIVE_CORRECT_INDEX(2),
	FIVE_CORRECT_BONUS_INDEX(3),
	SIX_CORRECT_INDEX(4);

	private final Integer num;

	GameNumber(Integer num) {
		this.num = num;
	}

	public Integer getNum() {
		return num;
	}

}