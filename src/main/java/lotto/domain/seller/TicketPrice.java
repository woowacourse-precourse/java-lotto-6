package lotto.domain.seller;

import java.math.BigDecimal;

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
