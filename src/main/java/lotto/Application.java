package lotto;

import lotto.domain.checker.Checker;
import lotto.domain.checker.LottoChecker;
import lotto.domain.customer.Customer;
import lotto.domain.customer.LottoCustomer;
import lotto.domain.generator.AutoTicketGenerator;
import lotto.domain.generator.TicketGenerator;
import lotto.domain.seller.Seller;
import lotto.domain.seller.TicketSeller;
import lotto.util.RandomNumberUtil;
import lotto.util.reader.InputReader;
import lotto.util.reader.LottoResultInputReader;
import lotto.util.reader.MagicNumberInputReader;
import lotto.util.reader.MoneyInputReader;

public class Application {
        public static void main(String[] args) {
                InputReader moneyInputReader = new MoneyInputReader();
                TicketGenerator generator = new AutoTicketGenerator(RandomNumberUtil.getInstance());
                Seller seller = new TicketSeller(generator);
                Customer customer = new LottoCustomer(moneyInputReader);

                customer.buyTicket(seller);

                InputReader resultInputReader = new LottoResultInputReader();
                InputReader magicNumberInputReader = new MagicNumberInputReader();
                Checker checker = new LottoChecker(resultInputReader, magicNumberInputReader);

                customer.checkLottoResult(checker);
        }
}
