package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;

public class LottoTicketFactory {

    private static int MIN_LOTTO_NUMBER_RANGE = 1;
    private static int MAX_LOTTO_NUMBER_RANGE = 45;
    private static int LOTTO_NUMBER_SIZE = 6;

    public static List<Lotto> lottoTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        while (tickets.size() < ticketCount) {
            tickets.add(lottoTicket());
        }
        return tickets;
    }

    private static Lotto lottoTicket() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER_RANGE, MAX_LOTTO_NUMBER_RANGE, LOTTO_NUMBER_SIZE));
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
