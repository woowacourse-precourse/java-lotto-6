package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public List<Lotto> issueTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / LOTTO_TICKET_PRICE;
        List<Lotto> tickets = new ArrayList<>();
        for(int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(generateRandomNumbers()));
        }
        return tickets;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return randomNumbers;
    }
}
