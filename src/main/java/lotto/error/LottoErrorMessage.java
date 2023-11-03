package lotto.error;

import static lotto.common.LottoNumberRange.LOTTO_END_NUMBER;
import static lotto.common.LottoNumberRange.LOTTO_START_NUMBER;

public enum LottoErrorMessage {
    LOTTO_NUMBER_OUT_OF_RANGE(
            String.format("로또 범위 이외의 숫자가 생성되었습니다. %d 부터 %d 숫자를 입력해주세요.", 
                    LOTTO_START_NUMBER, LOTTO_END_NUMBER));

    private final String message;

    private LottoErrorMessage(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}
