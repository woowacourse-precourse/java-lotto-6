package lotto.Print;

public class ErrorMessage {
    //구입 금액 에러 메세지
    public static final String INVALID_LOTTO_PRICE_ERROR = "[ERROR] 구입 금액은 1,000원 단위로 입력하여야 합니다.";
    //로또 당첨 번호 범위 에러 메세지
    public static final String INAVLID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    //로또 당첨 번호 중복 에러 메세지
    public static final String INVALID_LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.";
    //로또 보너스 번호 중복 에러 메세지
    public static final String INVALID_BONUS_NUMBER_DUPLICATE = "[ERROR] 해당 보너스 번호가 당첨 로또 번호 중에 있습니다. 다른 번호를 입력해주세요";
    //로또 번호 입력값이 숫자가 아닌 값이 입력되었을 때 에러 메세지
    public static final String INVALID_NUMBER_FORMAT = "[ERROR] 숫자를 입력해주세요.";

}