package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Store {
    public Store() {
    }

    public LottoTickets sellLottoTickets(final int budget) {
        int amount = budget / LottoTicket.PRICE_OF_LOTTO_TICKET;
        List<LottoTicket> tickets = new ArrayList<>();

        while (tickets.size() != amount) {
            tickets.add(new LottoTicket(createLotto()));
        }
        return new LottoTickets(tickets);
    }

    public Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() != Lotto.VALID_SIZE_OF_NUMBERS) {
            int number = Randoms.pickNumberInRange(Lotto.UPPER_BOUND_OF_NUMBER, Lotto.LOWER_BOUND_OF_NUMBER);
            if (isDuplicateNumber(numbers, number)) {
                numbers.add(number);
            }
        }
        return new Lotto(numbers);
    }

    private static boolean isDuplicateNumber(List<Integer> numbers, final int number) {
        return numbers.contains(number);
    }

}
