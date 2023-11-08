package lotto.game;

import lotto.constant.LottoNumber;

public enum LottoGameMessage {
    NON_NUMBER("[ERROR] 숫자를 입력해주세요."),
    NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.".formatted(
            LottoNumber.MINIMUM, LottoNumber.MAXIMUM));


    private final String message;

    LottoGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
