package lotto.domain.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.checker.Checker;
import lotto.domain.checker.LottoChecker;
import lotto.domain.fake.FakeInputReader;
import lotto.domain.fake.FakeRandomNumber;
import lotto.domain.generator.AutoTicketGenerator;
import lotto.domain.generator.TicketGenerator;
import lotto.domain.seller.Seller;
import lotto.domain.seller.TicketSeller;
import lotto.util.reader.InputReader;
import lotto.util.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCustomerTest {
        @DisplayName("성공: 플레이어는 로또 티켓을 구매할 수 있다.")
        @Test
        void call_buyTicket() {
                //given
                InputReader inputReader = new FakeInputReader("10000");
                RandomNumber randomNumber = new FakeRandomNumber(List.of(1, 2, 3, 4, 5, 6));
                TicketGenerator generator = new AutoTicketGenerator(randomNumber);
                Seller seller = new TicketSeller(generator);
                Customer customer = new LottoCustomer(inputReader);

                //when
                assertThatCode(() -> customer.buyTicket(seller)).doesNotThrowAnyException();
        }

        @DisplayName("성공: 플레이어는 로또 티켓의 결과를 확인할 수 있다.")
        @Test
        void call_checkLottoResult() {
                //given
                InputReader moneyInputReader = new FakeInputReader("2000");
                InputReader resultInputreader = new FakeInputReader("1,2,3,4,5,6");
                InputReader magicInputReader = new FakeInputReader("9");

                RandomNumber randomNumber = new FakeRandomNumber(List.of(1, 2, 3, 4, 5, 6));
                TicketGenerator generator = new AutoTicketGenerator(randomNumber);
                Seller seller = new TicketSeller(generator);
                Checker checker = new LottoChecker(resultInputreader, magicInputReader);
                Customer customer = new LottoCustomer(moneyInputReader);

                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                //when
                customer.buyTicket(seller);
                customer.checkLottoResult(checker);

                //then
                assertThat(out.toString().strip()).contains("200000000.0%");
        }
}
