package lotto.Utils;

public enum ErrorMessage{
	Lotto_Number_Count_Error("[ERROR] 로또 번호는 ','를 구분자로 하여 6개 값 입력해야 합니다."),
	Lotto_Number_Range_Error("[ERROR] 로또 번호는 1과 45사이의 숫자를 입력해야 합니다."),
	Lotto_Number_Redundant_Error("[ERROR] 로또 번호는 중복되지 않은 숫자를 입력해야 합니다."),
	Input_Invalid_Number_Error("[ERROR] 입력값은 정수를 입해야 합니다."),
	Input_Min_Budget_Range_Error("[ERROR] 참여 금액은 1,000단위로 입력해야 합니다."),
	Input_Positive_Budget_Error("[ERROR] 참여 금액은 양수로 입력해야 합니다."),
	Input_Void_Error("[ERROR] 값을 입력해야 합니다."),
	;
	
	private final String Error;
	
	ErrorMessage(String Error){
		this.Error = Error;
	}
	public String Message() {
		return Error;
	}
}