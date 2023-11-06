package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private ArrayList<ArrayList<Integer>> lottoTicket = new ArrayList<>();

    public Ticket(int buyTicketCount) {
        this.lottoTicket = lottoTicket(buyTicketCount);
    }

    public ArrayList<ArrayList<Integer>> getLottoTicket() {
        return lottoTicket;
    }

    private ArrayList<ArrayList<Integer>> lottoTicket(int buyTicketCount) {
        for (int i = 0; i < buyTicketCount; i++) {
            lottoTicket.add(new ArrayList<>(autoLottoNumber()));
        }
        return lottoTicket;
    }

    private List<Integer> autoLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
