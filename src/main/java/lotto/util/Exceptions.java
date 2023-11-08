package lotto.util;

public class Exceptions {


	public static class ErrorMessage {
		public static final String ERROR = "[ERROR] : ";
		public static final String BUDGET_IS_NOT_NUM = ERROR + "구입금액은 숫자여야 합니다.";
		public static final String WINNINGNUM_NOT_NUM = ERROR + "당첨 번호는 숫자여야 합니다.";
		public static final String BONUSNUM_NOT_NUM =  ERROR + "보너스 번호는 숫자여야 합니다.";
		public static final String WINNINGNUM_NOT_SIX = ERROR + "당첨 번호는 6개여야 합니다.";
		public static final String WINNINGNUM_NOT_DISTINCT = ERROR + "당첨 번호는 중복될 수 없습니다.";
		public static final String BONUSNUM_DUPLICATION = ERROR + "이미 당첨 번호에 포함된 보너스 번호입니다.";
		public static final String WINNINGNUM_RANGE_WRONG = ERROR + "당첨 숫자는 1에서 45 사이여야 합니다.";
		public static final String BUDGET_UNIT_WRONG = ERROR + "1,000원 단위의 숫자로 구입 금액을 입력해주세요.";
		public static final String NOT_NUM = ERROR + "숫자를 입력해주세요";
	}
}
