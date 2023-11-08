package lotto.exception;


import lotto.constant.ErrorMessageConstants;

import static lotto.constant.ErrorMessageConstants.LINE;
import static lotto.constant.LottoConstants.LOTTO_PRICE;

public class LottoException extends IllegalArgumentException {
    public enum ErrorMessage {
        RANGE_LOTTO_AMOUNT("숫자를 입력해 주세요. 로또 한장 금액은 " + LOTTO_PRICE.getValue() +"원 입니다." + LINE.getMessage() +
                "예시) 8,000(X), 8000(O)"),
        RANGE_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자입니다."),
        DUPLICATE_LOTTO_NUMBERS("1부터 45 사이의 중복되지 않는 숫자 6개를 입력해 주세요." + LINE.getMessage() +
                "양식: \"1,7,13,24,42,45\""),
        RANGE_BONUS_NUMBER("보너스 번호는 1부터 45 사이의 숫자입니다."),
        CONTAINS_ALREADY_BONUS_NUMBER("해당 보너스 번호는 이미 로또 번호에 포함됐습니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public LottoException(String message) {
        super(ErrorMessageConstants.ERROR_PREFIX.getMessage() + message + LINE.getMessage());
    }
}
