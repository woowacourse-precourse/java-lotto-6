package lotto.domain.customer;

import lotto.domain.checker.Checker;
import lotto.domain.seller.Seller;

public interface Customer {
        void buyTicket(Seller seller);
        void checkLottoResult(Checker checker);
}
