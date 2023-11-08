package lotto.utils;

import static lotto.utils.LottoSystemUtils.*;

public class ErrorPhrase {

    public static final String ERROR_PHRASE_MONEY_IS_NOT_DIGIT = "구입 금액은 숫자만 가능합니다.";

    public static final String ERROR_PHRASE_MONEY_IS_OUT_OF_RANGE = "구입 금액은 "+MONEY_MIN_RANGE+" ~ "+MONEY_MAX_RANGE+" 사이 숫자만 가능합니다.";

    public static final String ERROR_PHRASE_MONEY_IS_WRONG_UNIT = "구입 금액은 "+MONEY_UNIT+"원 단위만 가능합니다.";

    public static final String ERROR_PHRASE_LOTTO_NUMBER_IS_NOT_DIGIT = "로또 번호는 숫자만 가능합니다.";

}
