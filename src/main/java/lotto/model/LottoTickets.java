package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.Constant;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets generateTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tickets.add(new LottoTicket(getRandomTicket()));
        }
        return new LottoTickets(tickets);
    }

    private static List<Number> getRandomTicket() {
        return generateRandomTicket().stream()
                .map(Number::of)
                .collect(Collectors.toList());
    }

    private static List<Integer> generateRandomTicket() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                Constant.LOTTO_NUMBER_MIN.getIntValue(),
                Constant.LOTTO_NUMBER_MAX.getIntValue(),
                Constant.LOTTO_NUMBERS_MAX_LENGTH.getIntValue());
        randomNumbers.sort(Comparator.naturalOrder());
        return randomNumbers;
    }

}
