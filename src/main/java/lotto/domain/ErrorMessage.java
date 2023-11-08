package lotto.domain;

public class ErrorMessage {
	
	public static void typeError() {
		System.out.println("[ERROR] 입력값은 숫자와 쉼표(,)로 구성되어야합니다.");
	}
	
	public static void BonusError() {
		System.out.println("[ERROR] 입력값은 1개이며, 숫자여야 합니다.");
	}
	
	public static void numberError() {
		System.out.println("[ERROR] 입력값은 숫자만 가능합니다.");
	}
	
	public static void naturalOr0Error() {
		System.out.println("[ERROR] 입력값이 자연수가 아닙니다.");
	}
	
	public static void divisionError() {
		System.out.println("[ERROR] 입력값은 1000단위여야합니다.");
	}
	
	public static void validateError() {
		System.out.println("[ERROR] 입력값의 갯수는 6개여야합니다.");
	}
	
	public static void RangeError() {
		System.out.println("[ERROR] 입력값은 1~45사이의 숫자입니다.");
	}
	
	public static void RepeatError() {
		System.out.println("[ERROR] 입력값은 중복될 수 없습니다.");
	}
	
	public static void ResultError() {
		System.out.println("[ERROR] 예외 처리를 하지 않은 사항이 있습니다.");
	}
}
