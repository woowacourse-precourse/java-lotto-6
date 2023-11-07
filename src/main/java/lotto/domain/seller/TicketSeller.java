package lotto.domain.seller;

import java.math.RoundingMode;
import lotto.domain.generator.TicketGenerator;
import lotto.domain.money.Money;
import lotto.domain.ticket.Ticket;

/**
 * Seller 를 구현한 개념 객체를 나타내는 클래입니다.
 */
public class TicketSeller implements Seller {
        /**
         * 티켓 생성기입니다.
         */
        private final TicketGenerator generator;

        /**
         * TicketSeller 의 생성자 함수로 티켓 생성기를 주입 받습니다.
         * @param generator 생성기
         */
        public TicketSeller(TicketGenerator generator) {
                this.generator = generator;
        }

        /**
         * 구입 금액을 받고 티켓을 생성해서 반환합니다.
         *
         * @param payment 구입 금액
         * @return 티켓
         */
        @Override
        public Ticket sellTo(Money payment) {
                return generator.generateTicket(calculateQuantity(payment));
        }

        /**
         * 전달받은 구입 금액으로 구입할 수 있는 로또의 수를 계산합니다.
         *
         * @param payment 구입 금액
         * @return 구매 가능 수
         */
        private long calculateQuantity(Money payment) {
                return payment.amount()
                        .divide(TicketPrice.COMMON.getPrice(), 0, RoundingMode.DOWN)
                        .longValue();
        }
}
