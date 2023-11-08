package lotto.consts;

import static lotto.consts.LottoConst.LOTTO_MAX_NUMBER;
import static lotto.consts.LottoConst.LOTTO_MIN_NUMBER;
import static lotto.consts.LottoConst.LOTTO_PRICE;
import static lotto.consts.LottoConst.LOTTO_SIZE;

public class ErrorMsgConst {

    public static final String ERROR_ONLY_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    public static final String ERROR_NOT_BLANK = "[ERROR] 빈 칸은 입력하면 안 됩니다.";
    public static final String ERROR_SPLITED_ONLY_NUMBER = "[ERROR] ,로 구분된 숫자만 입력 가능합니다.";
    public static final String ERROR_BONUS_VALUE_RANGE =
            "[ERROR] 보너스 번호는 " + LOTTO_MIN_NUMBER + "과 " + LOTTO_MAX_NUMBER + "사이의 숫자여야 합니다.";
    public static final String ERROR_BONUS_DUPLICATE_WINNUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되는 숫자가 들어가면 안 됩니다.";

    public static final String ERROR_MONEY_DIVIDE = "[ERROR] 돈은 " + LOTTO_PRICE + "원으로 나누어 떨어져야 합니다.";
    public static final String ERROR_MONEY_MIN_VALUE = "[ERROR] 돈은 최소 " + LOTTO_PRICE + "원 이상이여야 합니다.";

    public static final String ERROR_WINNUMBER_SIZE = "[ERROR] " + LOTTO_SIZE + "개의 숫자를 입력해야 합니다.";
    public static final String ERROR_WINNUMBER_DUPLICATE_SIZE = "[ERROR] 중복되지 않는 숫자를 " + LOTTO_SIZE + "개 입력해야 합니다.";
    public static final String ERROR_WINNUMBER_VALUE_RANGE =
            "[ERROR] 모든 숫자는 " + LOTTO_MIN_NUMBER + "과 " + LOTTO_MAX_NUMBER + " 사이여야 합니다.";
}
