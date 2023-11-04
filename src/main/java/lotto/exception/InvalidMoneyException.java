package lotto.exception;

public class InvalidMoneyException extends IllegalArgumentException {

    public InvalidMoneyException(final long money) {
        super("[ERROR]" + money + "원은 올바르지 않은 금액입니다. 1,000원으로 나누어 떨어지는 금액을 입력해주세요");
    }
}
