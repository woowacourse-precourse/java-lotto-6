package lotto.global.exception;

import lotto.global.exception.base.LottoGameError;

public enum GlobalError implements LottoGameError {

    /** 입력값 요구 사항 에러 */
    BLANK_INPUT_ERROR("빈 값을 입력하셨습니다."),
    NOT_ENOUGH_MONEY("1,000 원 이상을 입력해주세요."),
    NOT_AVAILABLE_INTEGER("인식할 수 없는 정수 값입니다. 다시 입력해주세요."),

    //
    NOT_AVAILABLE_AMOUNT("유효한 구매 금액이 아닙니다. 1000원으로 나누어 떨어지는 1000원 이상의 금액을 입력해주세요."),
    NOT_AVAILABLE_LOTTO_NUMBER("유효한 로또 숫자가 아닙니다. 1부터 45 사이의 정수만 입력해주세요."),
    NOT_AVAILABLE_LOTTO_NUMBERS_PATTERN("잘못된 입력 형식입니다. 다시 입력해주세요."),

    // 보너스 번호 입력 에러
    ALREADY_EXIST_IN_WINNING_NUMBERS("이미 당첨 번호에 포함되어 있는 숫자입니다. 다른 숫자를 입력해주세요."),

    /** 잘못된 애플리케이션 메서드 호출 */
    NOT_PAID_YET("금액을 먼저 지불하세요."),
    TOO_MANY_LOTTOS("너무 많은 로또를 구매하셨습니다. 구매 금액을 줄여주세요."),
    ALREADY_REGISTER_WINNING("이미 당첨 번호와 보너스 번호가 등록되어 있습니다."),
    ;

    private final String errorMessage;

    GlobalError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

}
