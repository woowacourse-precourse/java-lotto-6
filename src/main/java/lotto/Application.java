package lotto;

import lotto.domain.checker.Checker;
import lotto.domain.checker.LottoChecker;
import lotto.domain.customer.Customer;
import lotto.domain.customer.LottoCustomer;
import lotto.domain.generator.AutoTicketGenerator;
import lotto.domain.generator.TicketGenerator;
import lotto.domain.seller.Seller;
import lotto.domain.seller.TicketSeller;
import lotto.util.RandomNumberGenerator;
import lotto.util.reader.ConsoleReader;
import lotto.util.reader.WinningNumberConsoleReader;
import lotto.util.reader.MagicNumberConsoleReader;
import lotto.util.reader.MoneyConsoleReader;

public class Application {
        public static void main(String[] args) {
                ConsoleReader moneyInputReader = new MoneyConsoleReader();
                TicketGenerator generator = new AutoTicketGenerator(RandomNumberGenerator.getInstance());
                Seller seller = new TicketSeller(generator);
                Customer customer = new LottoCustomer(moneyInputReader);

                customer.buyTicket(seller);

                ConsoleReader resultInputReader = new WinningNumberConsoleReader();
                ConsoleReader magicNumberInputReader = new MagicNumberConsoleReader();
                Checker checker = new LottoChecker(resultInputReader, magicNumberInputReader);

                customer.checkLottoResult(checker);
        }
}
