package lotto.util;

import lotto.domain.Buyer;

public enum Error {
    PRICE_WRONG("[ERROR] "+ Buyer.ONE_LOTTO_PRICE+"원 단위로 입력해주세요."),
    NOT_NUMBER("[ERROR] 숫자로 입력해주세요."),
    NOT_LOTTO_COUNT("[ERROR] 로또 번호는 " + Buyer.LOTTO_COUNT + "개 입력 가능합니다"),
    MIN_MAX_ERROR("[ERROR] 로또 번호는 " + Buyer.MIN_LOTTO_NUMBER + "부터 "
            + Buyer.MAX_LOTTO_NUMBER + "사이의 숫자여야 합니다.");
    final private String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
