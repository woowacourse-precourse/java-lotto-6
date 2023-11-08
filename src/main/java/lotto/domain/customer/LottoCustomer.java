package lotto.domain.customer;

import java.math.BigDecimal;
import lotto.domain.checker.Checker;
import lotto.domain.money.Money;
import lotto.domain.seller.Seller;
import lotto.domain.ticket.Ticket;
import lotto.util.reader.ConsoleReader;
import lotto.util.writer.LottoResultWriter;

/**
 * 로또 게임에 참여하는 Customer 역할의 개념 객체를 나타내는 클래스입니다.
 */
public class LottoCustomer implements Customer {
        private final ConsoleReader moneyConsoleReader;
        private Ticket ticket;

        public LottoCustomer(ConsoleReader consoleReader) {
                this.moneyConsoleReader = consoleReader;
        }

        /**
         * Seller 를 통해서 티켓을 구매할 수 있습니다. 금액은 moneyConsoleReader 클래스를 통해서 입력받고, Seller 에게 전달합니다.
         *
         * @param seller 판매자
         */
        @Override
        public void buyTicket(Seller seller) {
                Money payment = new Money(new BigDecimal(moneyConsoleReader.readLine()));
                ticket = seller.sellTo(payment);
        }

        /**
         * 구매한 로또의 결과를 Checker 에게 요청합니다.
         *
         * @param checker 로또 결과 판단자
         */
        @Override
        public void checkLottoResult(Checker checker) {
                LottoResultWriter.write(checker.checkTicket(ticket));
        }
}
