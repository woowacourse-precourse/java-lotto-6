package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.LottoSetting.*;

public class LottoGenerator {

    public List<Lotto> issueTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / PRICE_PER_TICKET.value();
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(issueLottoTicket());
        }

        return tickets;
    }

    public Lotto issueLottoTicket() {
        return new Lotto(generateUniqueRandomNumbers());
    }


    private List<Integer> generateUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.value(), MAX_LOTTO_NUMBER.value(), LOTTO_SIZE.value());
    }

}
