package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.constants.LottoDefaultRule;

public class Ticket {
    private ArrayList<ArrayList<Integer>> lottoTicket = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> createLottoTickets(int buyTicketCount) {
        for (int i = 0; i < buyTicketCount; i++) {
            lottoTicket.add(new ArrayList<>(autoLottoNumber()));
        }
        return lottoTicket;
    }

    private List<Integer> autoLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoDefaultRule.PICK_MIN_NUMBER.getRule(),
                LottoDefaultRule.PICK_MAX_NUMBER.getRule(), LottoDefaultRule.PICK_HIT_NUMBER_TOTAL.getRule());
    }

    public void setLottoTicket(int buyTicketCount) {
        this.lottoTicket = createLottoTickets(buyTicketCount);
    }

    public ArrayList<ArrayList<Integer>> getLottoTicket() {
        return lottoTicket;
    }
}
