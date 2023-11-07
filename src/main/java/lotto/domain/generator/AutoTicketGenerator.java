package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.Ticket;
import lotto.util.Logger;
import lotto.util.RandomNumber;

/**
 * TicketGenerator 를 구현한 개념 객체를 나타내는 클래스입니다.
 */
public class AutoTicketGenerator implements TicketGenerator {
        public static final int LOTTO_RANGE_START = 1;
        public static final int LOTTO_RANGE_END = 45;
        public static final int LOTTO_NUMBER_SIZE = 6;

        /**
         * 자동으로 무작위 숫자를 생성 후 반환하는 유틸 클래스입니다.
         */
        private final RandomNumber randomNumber;

        /**
         * AutoTicketGenerator 의 생성자 함수로 유틸 클래스를 주입 받습니다.
         *
         * @param randomNumber 무작위 숫자 생성 유틸 클래스
         */
        public AutoTicketGenerator(RandomNumber randomNumber) {
                this.randomNumber = randomNumber;
        }

        /**
         * 티켓 생성을 생성 후 반환합니다.
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

        /**
         * 무작위 숫자로 구성된 로또 객체를 반환합니다.
         *
         * @return 로또
         */
        private Lotto generateLotto() {
                List<Integer> balls = randomNumber.pickUniqueNumberRange(LOTTO_RANGE_START,
                        LOTTO_RANGE_END,
                        LOTTO_NUMBER_SIZE);

                Logger.info(balls.toString());
                return new Lotto(balls);
        }
}
