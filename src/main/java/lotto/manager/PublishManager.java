package lotto.manager;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import java.util.ArrayList;
import java.util.List;
import static lotto.utility.IntegerUtil.*;
import static lotto.utility.StringUtil.PRINT_TICKET_COUNT;

public class PublishManager {

    private static PublishManager publishManager;
    private static int ticketCount;
    private static List<Lotto> lottos;

    private PublishManager() {

    }

    public static PublishManager getInstance() {
        if ( publishManager == null ) {
            publishManager = new PublishManager();
        }
        return publishManager;
    }

    public void generateTickets(int payAmount) {
        ticketCount = payAmount / PAY_AMOUNT_UNIT.getValue();
    }

    public void generateLottos() {
        lottos = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(generateLottoNumber());
            lottos.add(lotto);
        }

        StatisticsManager.getInstance().setLottos(lottos);
    }

    public List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START_INCLUSIVE.getValue(),
                LOTTO_NUMBER_END_INCLUSIVE.getValue(),
                LOTTO_NUMBER_COUNT.getValue()
        );
    }

    public void printTicketCount() {
        System.out.printf(PRINT_TICKET_COUNT.getMessage(), ticketCount);
    }

    public void printLottoList() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
