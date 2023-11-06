package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.Ticket;
import lotto.util.Logger;
import lotto.util.RandomNumber;

public class AutoTicketGenerator implements TicketGenerator {
        private final RandomNumber randomNumber;

        public AutoTicketGenerator(RandomNumber randomNumber) {
                this.randomNumber = randomNumber;
        }

        @Override
        public Ticket generateTicket(long quantity) {
                Logger.info("\n"+quantity+"개를 구매했습니다.");
                List<Lotto> lottoEntry = new ArrayList<>();
                for (int i = 0; i < quantity; i++) {
                        lottoEntry.add(generateLotto());
                }

                return new LottoTicket(lottoEntry);
        }

        private Lotto generateLotto() {
                List<Integer> balls = randomNumber.pickUniqueNumberRange(1, 45, 6);
                Logger.info(balls.toString());
                return new Lotto(balls);
        }
}
