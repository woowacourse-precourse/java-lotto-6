package lotto.domain.customer;

import lotto.domain.checker.Checker;
import lotto.domain.seller.Seller;

/**
 * Customer 의 핵심 로직이 정의된 인터페이스입니다.
 */
public interface Customer {
        /**
         * Customer 는 Seller 를 통해 로또 티켓을 구매할 수 있습니다.
         * @param seller 판매자
         */
        void buyTicket(Seller seller);

        /**
         * Customer 는 Checker 에게 로또 결과를 요청할 수 있습니다.
         * @param checker 로또 결과 판단자
         */
        void checkLottoResult(Checker checker);
}
