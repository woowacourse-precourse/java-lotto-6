package lotto.exception;

public enum ModelExceptionConstant {
    OUT_OF_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45사이의 숫자이어야 합니다."),
    NOT_DIVIDE_BY_LOTTO_PRICE("[ERROR] 로또 구입 금액이 로또 1장의 가격으로 나누어 떨어지지 않습니다."),
    OUT_OF_WINNING_NUMBERS_SIZE("[ERROR] 당첨 번호 개수가 6개가 아닙니다."),
    DUPLICATED_NUMBERS("[ERROR] 중복된 번호가 존재합니다.");
    private final String text;
    ModelExceptionConstant(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
