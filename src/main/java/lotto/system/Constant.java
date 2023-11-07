package lotto.system;

public enum Constant {
	LOTTO_LENGTH(6),
	LOTTO_START_NUMBER(1),
	LOTTO_END_NUMBER(45),
	FIRST_RANK(1),
	SECOND_RANK(2),
	THIRD_RANK(3),
	FOURTH_RANK(4),
	LAST_RANK(5),
	FIRST_RANK_MATCH_COUNT(6),
	SECOND_RANK_MATCH_COUNT(5),
	THIRD_RANK_MATCH_COUNT(5),
	FOURTH_RANK_MATCH_COUNT(4),
	LAST_RANK_MATCH_COUNT(3),
	LAST_RANK_PRIZE(5000),
	FOURTH_RANK_PRIZE(50000),
	THIRD_RANK_PRIZE(1500000),
	SECOND_RANK_PRIZE(30000000),
	FIRST_RANK_PRIZE(2000000000);
	private final int constant;
	
	Constant(int constant) {
		this.constant = constant;
	}
	
	public int getconstant() {
		return constant;
	}
}