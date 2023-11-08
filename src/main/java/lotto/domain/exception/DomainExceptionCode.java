package lotto.domain.exception;

import java.util.function.Supplier;

public enum DomainExceptionCode {

    BONUS_NUMBER_MUST_BE_BETWEEN_SIZE("보너스 번호는 1과 45사이의 숫자만 허용합니다."),
    LOTTO_SIZE_MUST_BE_SAME("로또 번호는 6자리여야 합니다."),
    LOTTO_MUST_NOT_BE_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    MONEY_GRATER_THAN_ZERO("돈은 0원보다 작을 수 없습니다."),
    LOTTO_PAYMENT_PRICE_REQUIRED("로또는 1000원 단위로 구매할 수 있습니다."),
    ANSWER_LOTTO_AND_BONUS_NUMBER_DUPLICATE("당첨 로또번호와 보너스 번호가 일치합니다."),
    BONUS_NUMBER_MUST_BE_REQUIRED("보너스 번호가 등록되어 있지 않습니다.");

    private final String message;

    DomainExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void dynamicInvokeBy(Supplier<Boolean> condition) {
        if (condition.get()) {
            throw new DomainException(this.message);
        }
    }

}
