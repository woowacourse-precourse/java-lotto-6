package lotto.constant;

public class ErrorMessage {

    public static final String PURCHASE_WRONG
            = "[ERROR] 구입금액은 " + LottoNumber.PURCHASE_CONDITION.getNumber() + "원 단위로 입력해야합니다.";

    public static final String PURCHASE_ONLY_NUMBER
            = "[ERROR] 구입금액은 숫자로만 입력해야합니다.";

    public static final String WINNING_NUMBER_SIZE
            = "[ERROR] 당첨번호는 " + LottoNumber.LENGTH_CONDITION.getNumber() + "자리로 입력해야합니다.";

    public static final String WINNING_NUMBER_DUPLICATE
            = "[ERROR] 당첨번호는 중복될 수 없습니다.";

    public static final String WINNING_NUMBER_RANGE
            = "[ERROR] 로또 번호는 " + LottoNumber.FIRST_RANGE.getNumber() + "부터 " + LottoNumber.LAST_RANGE.getNumber() + " 사이의 숫자여야 합니다.";

    public static final String BONUS_NUMBER_RANGE
            = "[ERROR] 보너스번호는 " + LottoNumber.FIRST_RANGE.getNumber() + "부터 " + LottoNumber.LAST_RANGE.getNumber() + " 사이의 숫자여야 합니다.";
}
