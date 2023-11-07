package lotto.Utils;

public enum ErrorMessage{
	Lotto_Number_Count_Error("[Error] 로또 번호는 6개를 입력해야 합니다."),
	Lotto_Number_Range_Error("[Error] 로또 번호는 1과 45사이의 숫자를 입력해야 합니다."),
	Lotto_Number_Redundant_Error("[Error] 로또 번호는 중복되지 않은 숫자를 입력해야 합니다."),
	Input_Invalid_Number_Error("[Error] 입력값은 정수를 입해야 합니다."),
	Input_Min_Budget_Range_Error("[Error] 참여 금액은 1,000단위로 입력해야 합니다."),
	;
	
	private final String Error;
	
	ErrorMessage(String Error){
		this.Error = Error;
	}
	public String Message() {
		return message;
	}
	
}