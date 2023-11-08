package lotto.domain.seller;

import java.math.BigDecimal;

/**
 * 티켓의 기준 가격을 가진 enum 클래스입니다.
 */
public enum TicketPrice {
        COMMON(BigDecimal.valueOf(1000));
        private final BigDecimal price;

        TicketPrice(BigDecimal price) {
                this.price = price;
        }

        public BigDecimal getPrice() {
                return price;
        }
}
