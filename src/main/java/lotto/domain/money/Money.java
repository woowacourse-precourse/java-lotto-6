package lotto.domain.money;

import java.math.BigDecimal;

/**
 * Money 의 레코드 클래스입니다.
 * @param amount 잔액
 */
public record Money(BigDecimal amount) {

        /**
         * 주어진 금액과 잔액을 더할 수 있다.
         * @param money 주어진 금액
         * @return 증가된 총액의 Money 객체
         */
        public Money addition(Money money) {
                return new Money(amount.add(money.amount()));
        }

        /**
         * 주어진 금액과 잔액을 뺄 수 있다.
         * @param money 주어진 금액
         * @return 감소된 총액의 Money 객체
         * @throws IllegalArgumentException : 만약 주어진 금액 보다 잔액이 작은 경우
         */
        public Money subtraction(Money money) {
                if (amount.compareTo(money.amount()) < 0) {
                        throw new IllegalArgumentException("잔액이 부족합니다.");
                }

                return new Money(amount.subtract(money.amount()));
        }
}
