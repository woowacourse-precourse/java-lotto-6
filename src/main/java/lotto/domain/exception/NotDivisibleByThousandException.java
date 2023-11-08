package lotto.domain.exception;

public class NotDivisibleByThousandException extends IllegalArgumentException {
    public NotDivisibleByThousandException() {
        super("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.\n");
    }
}

