package lotto.domain.money;

import java.util.Objects;
import lotto.domain.money.exception.InvalidMoneyAmountException;

/**
 * 사용자가 로또 구입을 위해 입력한 금액을 표현하는 `Wrapper` class입니다. 잔액이 음수로 떨어져서 문제가 발생하지 않도록 기본적인 검증을 해줄 수 있으며, 직접 `amount`를 조작하는 것이
 * 아니라, `increase`, `decrease` 등의 메소드를 통해 생성 시점 뿐만 아니라, 값을 변경할 때도 검증이 가능합니다.
 * <p>
 * 또한 다른 `Money` 혹은 `int`와 금액 비교도 가능합니다.
 */
public final class Money {

    /**
     * Money가 반드시 가져야 하는 최소 금액입니다.
     */
    private static final int MIN_AMOUNT = 0;

    /**
     * Money의 잔액을 나타내는 필드입니다. 메소드를 통해 변경 가능합니다.
     */
    private final long amount;

    /**
     * Money 생성 시, <h3 color="#bf0f4d">amount는 반드시 0 이상이어야 합니다.</h3>
     */
    private Money(final long amount) {
        validateMoneyAmount(amount);
        this.amount = amount;
    }

    /**
     * Money 생성 시, <h3 color="#bf0f4d">amount는 반드시 0 이상이어야 합니다.</h3>
     */
    public static Money from(final long amount) {
        return new Money(amount);
    }

    /**
     * Money를 deepcopy합니다.
     */
    public static Money clone(final Money money) {
        return new Money(money.amount);
    }

    /**
     * 소지금이 0인 Money를 생성합니다.
     */
    public static Money zero() {
        return new Money(0);
    }

    /**
     * 입력된 `amount`를 검증하며, 음수일 경우 예외가 발생합니다.
     */
    private static void validateMoneyAmount(final long amount) {
        if (amount < MIN_AMOUNT) {
            throw new InvalidMoneyAmountException();
        }
    }

    /**
     * 현재 가진 소지금에서 amount 만큼을 더한 불변 객체 반환.
     */
    public Money increased(final Money other) {
        return new Money(amount + other.amount);
    }

    /**
     * 현재 가진 소지금에서 amount 만큼을 제한 불변 객체 반환.
     */
    public Money decreased(final Money other) {
        return new Money(amount - other.amount);
    }

    /**
     * 현재 가진 소지금 * x
     */
    public Money multiplied(final int x) {
        return new Money(amount * x);
    }

    /**
     * 금액 대소여부 비교
     */
    public boolean isLessThan(final Money other) {
        return this.amount < other.amount;
    }

    /**
     * 금액이 같거나 큰지 비교
     */
    public boolean isEqualsOrGreaterThan(final Money other) {
        return this.amount >= other.amount;
    }

    /**
     * Double로 변환(Koltin과 동일한 함수명)
     */
    public double toDouble() {
        return amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }


    public long toLong() {
        return amount;
    }
}
