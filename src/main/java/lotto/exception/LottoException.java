package lotto.exception;


import lotto.constant.ErrorMessageConstants;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

public class LottoException extends IllegalArgumentException {
    public enum ErrorMessage {
        MIN_AMOUNT("로또 금액은 " + LOTTO_PRICE.getValue() +"원 입니다."),
        INVALID_NUMBERS("1부터 45 사이의 중복되지 않는 숫자 6개를 입력해주세요.\n" +
                "양식: \"1,7,13,24,42,45\""),
        ALREADY_CONTAINS_BONUS_NUMBER("해당하는 보너스 번호는 이미 로또에 포함되어 있습니다.\n");
        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public LottoException(String message) {
        super(ErrorMessageConstants.ERROR_PREFIX.getMessage() + message);
    }
}
