package lotto;

public class Constants {
	//Setting
	public static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
	public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	public static final String AMOUNT_ERROR_MSG = "[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요.";
	public static final String NUMBER_ERROR_MSG = "[ERROR] 중복되지 않는 6개의 숫자를 쉼표(,)를 기준으로 공백 없이 입력해 주세요.";
	public static final String BONUS_ERROR_MSG = "[ERROR] 당첨 번호와 중복되지 않는1개의 숫자를 입력해 주세요.";
	public static final String EMPTY_ERROR_MSG = "[ERROR] 입력값을 확인해 주세요.";
	public static final String RANGE_ERROR_MSG = "[ERROR] 입력값의 범위는 1 ~ 45 입니다.";
	public static final String TICKET_GUIDE_STR = "개를 구매했습니다.";
	public static final int LIMIT_LOTTO_NUMBER = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    
    //WinningResult
    public static final String RESULT_GUIDE_STR = "당첨 통계";
	public static final String RESULT_GUIDE_BAR = "---";
	public static final String RESULT_GUIDE_CNT = "개";
	public static final String RESULT_TOTAL_RATE = "총 수익률은 ";
	public static final String RESULT_PERCENTAGE_STR = "%입니다.";
}
