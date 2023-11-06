package lotto.domain.money;

import java.math.BigDecimal;

public class Money {
        private final BigDecimal amount;

        public Money(BigDecimal amount) {
                this.amount = amount;
        }

        public Money addition(Money money) {
                return new Money(amount.add(money.getAmount()));
        }

        public Money subtraction(Money money) {
                if (amount.compareTo(money.getAmount()) < 0) {
                        throw new IllegalArgumentException("잔액이 부족합니다.");
                }

                return new Money(amount.subtract(money.getAmount()));
        }

        public BigDecimal getAmount() {
                return amount;
        }
}
