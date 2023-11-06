package lotto.constants;

import static lotto.constants.NumConstant.PRICE;

public enum ErrorConstants {
    DUPLICATEDERROR("[ERROR] 로또 번호가 중복됩니다"),NOTINARRANGEERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOTNUMBERERROR("[ERROR] 숫자만 입력해주세요"),ENTERNULLERROR("[ERROR] 금액을 입력해 주세요"),
    ENTERUNITERROR("[ERROR] " + PRICE.getValue() + "원 단위로 입력해주세요");

    private String value;

    ErrorConstants(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
