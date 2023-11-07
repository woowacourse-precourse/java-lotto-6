package lotto.output;

public class Constants {
    public class PurchaseHandlerConstants{
        public static final String AMOUNT_INPUT = "구입금액을 입력해 주세요.";
        public static final String THOUSAND_FORMAT_ERROR_MESSAGE = "[ERROR] 올바른 형식이 아닙니다. 1000원 단위로 다시 입력해주세요.";
        public static final String MINIMUM_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 이상이어야 합니다.";

    }

    public class WinningNumbersConstants{
        public static final String SIX_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
        public static final String SIX_LENGTH_ERROR_MESSAGE = "[ERROR] 6개의 서로 다른 숫자를 입력하세요.";
    }

    public class BonusNumberConstants {
        public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
        public static final String ONE_LENGTH_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복되지 않는 숫자 1개를 입력하세요.";

    }

    public class NumbersValidatorConstants {
        public static final String FORMAT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
        public static final String RANGE_ERROR_MESSAGE = "[ERROR] 1과 45 사이의 숫자를 입력해주세요";
        public static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 숫자가 존재합니다. 다시 입력해주세요.";

    }

    public class LottoConstants {
        public static final String LOTTO_SIX_NUMBERS = "[ERROR] 로또 번호는 6개가 되어야 합니다.";
        public static final String LOTTO_DUPLICATE_ERROR_MESSAGE = "[ERROR] 중복된 번호가 있습니다.";
        public static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    }

}
