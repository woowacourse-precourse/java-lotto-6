package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public List<LottoTicket> purchaseTickets(int money) {
        int numberOfTickets = money / LOTTO_PRICE;
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(generateRandomTicket());
        }

        return tickets;
    }

    private LottoTicket generateRandomTicket() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                NUMBER_OF_LOTTO_NUMBERS
        );
        return new LottoTicket(randomNumbers);
    }
}
