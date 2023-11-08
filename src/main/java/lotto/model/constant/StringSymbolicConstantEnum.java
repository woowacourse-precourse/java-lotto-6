package lotto.model.constant;

public enum StringSymbolicConstantEnum {
	SPLIT_POINT(","),
	CHANGE_LINE("\n"),
	END_STRING_FOR_PURCHASE_AMOUNT("개를 구매했습니다."),
	TITLE_OF_LOTTO_WINNING_STATUS("당첨통계\n---"),
	INITIALIZE_FOR_BIG_INT("0");


	private final String value;

	StringSymbolicConstantEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
