package lotto.exception;

import lotto.constant.LottoConstant;

public enum ModelExceptionConstant {

    OUT_OF_LOTTO_NUMBER_RANGE(String.format("[ERROR] 로또 번호는 %d부터 %d사이의 숫자이어야 합니다."
            , LottoConstant.START_LOTTO_NUMBER.value(), LottoConstant.END_LOTTO_NUMBER.value())),
    NOT_DIVIDE_BY_LOTTO_PRICE("[ERROR] 로또 구입 금액이 로또 1장의 가격으로 나누어 떨어지지 않습니다."),
    OUT_OF_WINNING_NUMBERS_SIZE(String.format("[ERROR] 당첨 번호 개수가 %d개가 아닙니다."
            , LottoConstant.LOTTO_NUMBER_COUNT.value())),
    DUPLICATED_NUMBERS("[ERROR] 중복된 번호가 존재합니다.");
    private final String text;

    ModelExceptionConstant(String text) {
        this.text = text;
    }

    public String getText() {

        return this.text;
    }
}
