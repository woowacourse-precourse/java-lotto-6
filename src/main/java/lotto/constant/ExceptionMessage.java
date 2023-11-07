package lotto.constant;

import static lotto.constant.Game.LOTTO_PRICE;
import static lotto.constant.Game.MAX_NUMBER;
import static lotto.constant.Game.MIN_NUMBER;
import static lotto.constant.Game.TOTAL_PICK;

public enum ExceptionMessage {
    COUNT(String.format("%d개의 숫자만 쉼표로 구분하여 입력되어야 합니다.", TOTAL_PICK.getNum())),
    DUPLICATE("중복된 수는 입력될 수 없습니다."),
    LOTTO_NUMBER(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_NUMBER.getNum(), MAX_NUMBER.getNum())),
    PRICE(String.format("구입 금액은 %d의 배수여야 합니다.", LOTTO_PRICE.getNum()));

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
