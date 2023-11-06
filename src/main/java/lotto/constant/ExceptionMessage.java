package lotto.constant;

import static lotto.constant.LottoConstant.*;

public class ExceptionMessage {

    public static final String ERROR_NOT_MULTIPLES_NUMBER = "[ERROR] 로또 구입 금액은 " + MIN_AMOUNT_OF_LOTTO + " 원 단위어야 합니다.";
    public static final String ERROR_NOT_AMOUNT_RANGE = "[ERROR] 로또 구입 금액은 " + MIN_AMOUNT_OF_LOTTO + " ~ " + MAX_AMOUNT_OF_LOTTO + " 원 이어야 합니다.";
    public static final String ERROR_NOT_NUMBER = "[ERROR] 숫자가 아닙니다.";
    public static final String ERROR_NOT_IN_SPLIT_WORD = "[ERROR] 구분자가 없습니다.";
    public static final String ERROR_NOT_NUMBERS_SIZE = "[ERROR] 로또 번호는 "+ LOTTO_NUMBER_SIZE +"개 이어야 합니다.";
    public static final String ERROR_DUPLICATE_NUMBERS = "[ERROR] 로또 번호에 중복이 있습니다.";
    public static final String ERROR_BONUS_IN_WINNER_NUMBERS = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";
    public static final String  ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 " + LOTTO_START_NUMBER + " ~ " + LOTTO_END_NUMBER + "이어야 합니다.";

}
