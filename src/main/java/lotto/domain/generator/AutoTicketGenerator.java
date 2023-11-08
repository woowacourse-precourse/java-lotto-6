package lotto.domain.generator;

import static lotto.domain.customer.LottoNumberSpec.SIZE;
import static lotto.domain.customer.LottoNumberSpec.END_INCLUSIVE;
import static lotto.domain.customer.LottoNumberSpec.START_INCLUSIVE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.Ticket;
import lotto.util.Logger;
import lotto.util.RandomNumbers;

/**
 * 로또 티켓을 생성하는 TicketGenerator 역할의 개념 객체를 나타내는 클래스입니다.
 */
public class AutoTicketGenerator implements TicketGenerator {
        private final RandomNumbers randomNumberGenerator;

        public AutoTicketGenerator(RandomNumbers randomNumber) {
                this.randomNumberGenerator = randomNumber;
        }

        /**
         * 전달 받은 수량의 로또 번호를 포함한 티켓 생성을 생성 후 반환합니다.
         *
         * @param quantity 로또 구매 수량
         * @return 티켓
         */
        @Override
        public Ticket generateTicket(long quantity) {
                Logger.info("\n" + quantity + "개를 구매했습니다.");
                List<Lotto> lottoEntry = new ArrayList<>();
                for (int i = 0; i < quantity; i++) {
                        lottoEntry.add(generateLotto());
                }

                return new LottoTicket(lottoEntry);
        }

        private Lotto generateLotto() {
                List<Integer> balls = randomNumberGenerator.pickUniqueNumberRange(START_INCLUSIVE.toInt(),
                        END_INCLUSIVE.toInt(),
                        SIZE.toInt());

                Logger.info(balls.toString());
                return new Lotto(balls);
        }
}
