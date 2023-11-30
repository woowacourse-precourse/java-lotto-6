package lotto.utils.phrase;

import static lotto.utils.system.LottoSystemUtils.*;

public class ErrorPhrase {

    public static final String ERROR_PHRASE_MONEY_IS_NOT_DIGIT = "구입 금액은 숫자만 가능합니다.";

    public static final String ERROR_PHRASE_MONEY_IS_OUT_OF_RANGE = "구입 금액은 "+MONEY_MIN_RANGE+" ~ "+MONEY_MAX_RANGE+" 사이 숫자만 가능합니다.";

    public static final String ERROR_PHRASE_MONEY_IS_WRONG_UNIT = "구입 금액은 "+MONEY_UNIT+"원 단위만 가능합니다.";

    public static final String ERROR_PHRASE_INPUT_RIGHT_LOTTO_CNT = "로또 번호는 "+LOTTO_CNT+"개만 입력 가능합니다.";

    public static final String ERROR_PHRASE_LOTTO_NUMBER_IS_DUPLICATED = "로또 번호는 중복된 값을 가질 수 없습니다.";

    public static final String ERROR_PHRASE_LOTTO_NUMBER_IS_OUT_OF_RANGE = "로또 번호는 "+LOTTO_NUMBER_MIN_RANGE+" ~ "+LOTTO_NUMBER_MAX_RANGE+" 사이 숫자만 가능합니다.";

    public static final String ERROR_PHRASE_LOTTO_NUMBER_IS_NOT_DIGIT = "로또 번호는 숫자만 가능합니다.";

    public static final String ERROR_PHRASE_BONUS_LOTTO_NUMBER_IS_DUPLICATED = "보너스 번호는 로또 번호와 중복된 값을 가질 수 없습니다.";

}
