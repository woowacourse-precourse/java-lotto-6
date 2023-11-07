package lotto.constant;

public enum Error {
    PURCHASE_TYPE("[ERROR] 구매 금액은 숫자여야 합니다."),
    PURCHASE_UNIT("[ERROR] 구매 금액은 " + Number.PURCHASE_UNIT.getRange() + "원으로 나누어 떨어져야 합니다."),
    NUMBER_COUNT("[ERROR] 당첨 번호는 " + Number.CNT.getRange() + "개를 입력해야 합니다."),
    NUMBER_BLANK("[ERROR] 당첨 번호는 ,(쉼표)로 구분하며며, 공백을 포함할 수 없습니다."),
    NUMBER_DUPLICATE("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    NUMBER_RANGE("[ERROR] 로또 번호는 " + Number.MIN.getRange() + "부터 " + Number.MAX.getRange() + " 사이의 숫자여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
