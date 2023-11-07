package lotto.domain.exception;

import java.util.function.Supplier;

public enum DomainExceptionCode {

    BONUS_NUMBER_MUST_BE_BETWEEN_SIZE("보너스 번호는 1과 45사이의 숫자만 허용합니다."),
    LOTTO_SIZE_MUST_BE_SAME("로또 번호는 6자리여야 합니다."),
    LOTTO_MUST_NOT_BE_DUPLICATE("로또 번호는 중복될 수 없습니다.");

    private final String message;


    DomainExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public DomainException create() {
        return new DomainException(this.message);
    }

    public void dynamicInvokeBy(Supplier<Boolean> condition) {
        if (condition.get()) {
            throw new DomainException(this.message);
        }
    }

}
