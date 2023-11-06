package lotto.exception;

import lotto.constance.GameConst;

public enum LottoGameException {

    WRONG_LOTTO_SIZE(String.format("로또 숫자의 개수는 %d 개여야 합니다.",
            GameConst.LOTTO_SIZE)),
    WRONG_LOTTO_RANGE(String.format("잘못된 범위의 숫자가 존재합니다. 숫자 범위 : %d ~ %d",
            GameConst.LOTTO_RANGE_START, GameConst.LOTTO_RANGE_END)),
    DUPLICATED_LOTTO_NUMBER("로또 번호에 중복된 숫자가 존재합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 숫자가 로또 번호와 중복됩니다."),

    WRONG_NUMBER_FORMAT("숫자를 입력해 주세요"),
    WRONG_ANSWERS_FORMAT("입력 형식이 잘못되었습니다. 여섯 개의 숫자를 ,로 구분해 입력해 주세요"),
    WRONG_MONEY_UNIT(String.format("%d원 단위로 입력해 주세요", GameConst.MONEY_UNIT)),

    OVER_PURCHASE_LIMIT(String.format("인당 구매할 수 있는 최대 금액은 %d원 입니다.",
            GameConst.LOTTO_PURCHASE_LIMIT));

    private String exceptionMessage;

    LottoGameException(String message) {
        this.exceptionMessage = message;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public IllegalArgumentException makeException() {
        return new IllegalArgumentException(this.exceptionMessage);
    }
}
