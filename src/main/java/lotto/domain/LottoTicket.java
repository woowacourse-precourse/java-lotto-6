package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.*;

public class LottoTicket {
    private final List<Lotto> ticket = new ArrayList<>();;

    public LottoTicket(int ticketCount){
        for (int i=0; i<ticketCount; i++){
            List<Integer> numbers = Randoms
                    .pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_COUNT);
            ticket.add(new Lotto(numbers));
        }
    }
}