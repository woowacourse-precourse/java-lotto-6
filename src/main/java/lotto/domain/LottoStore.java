package lotto.domain;

import static lotto.Exception.ExceptionMessage.LOTTO_TICKET_PRICE;
import static lotto.utils.Constance.*;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public int calculateLottoTicketCount(int playerMoney) {
        if (playerMoney % 1000 != 0) {
            throw new IllegalArgumentException(LOTTO_TICKET_PRICE.getExceptionMessage());
        }
        return playerMoney / 1000;
    }

    public List<Lotto> createLottoTickets(int ticketCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(new Lotto(pickUniqueNumbersInRange(
                    LOTTO_MIN_NUMBER.getValue(),
                    LOTTO_MAX_NUMBER.getValue(),
                    LOTTO_MAX_LENGTH.getValue())));
        }
        return lottoList;
    }
}
