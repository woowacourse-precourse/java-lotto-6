package lotto.view;

public enum ExceptionText {
	NUMBER("유효한 숫자 형식이 아닙니다."),
	MULTIPLE("가격은 1000으로 나누어 떨어져야 합니다."),
	EMPTY("빈값입니다. 입력해주세요."),
	ERROR("[ERROR] "),
	DIFFERENT_NUMBER("6개의 숫자가 아닙니다."),
	BEYOND_SCOPE("숫자가 1에서 45 범위 밖에 있습니다."),
	DUPLICATE_NUMBERS("중복된 숫자가 있습니다."),
	INPUT_NUMBER_ERROR("올바른 숫자가 아닙니다."),
	DUPLICATE_WIN_BONUS("보너스 숫자가 승리 숫자와 중복됩니다."),
	WINNING_NUMBERS_NULL("승리숫자가 아직 준비되지 않았습니다.");
	private final String text;

	ExceptionText(String str) {
		this.text = str;
	}

	public String getText() {
		return text;
	}
}