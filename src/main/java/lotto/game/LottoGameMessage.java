package lotto.game;

import lotto.constant.LottoGameNumber;

public enum LottoGameMessage {
    NON_NUMBER("[ERROR] 숫자를 입력해주세요."),
    INVALID_COST_UNIT("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.".formatted(
            LottoGameNumber.MINIMUM, LottoGameNumber.MAXIMUM)),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.".formatted(
            LottoGameNumber.MINIMUM, LottoGameNumber.MAXIMUM)),
    INVALID_LOTTO_NUMBERS("[ERROR] 로또는 중복되지 않은 %d부터 %d 사이의 숫자 %d자리여야 합니다.".formatted(
            LottoGameNumber.MINIMUM, LottoGameNumber.MAXIMUM, LottoGameNumber.COUNT));

    private final String message;

    LottoGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
