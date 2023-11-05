package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> issuedLotto;

    public LottoMachine(int lottoTicket) {
        this.issuedLotto = new ArrayList<>();
        issueTickets(lottoTicket);
    }

    public void issueTickets(int ticketCount) {
        int init = 1;
        while(init <= ticketCount) {
            List<Integer> numbers =
                new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(numbers);
            issuedLotto.add(new Lotto(numbers));
            init++;
        }
    }

    public List<Lotto> getIssuedLotto() {
        return this.issuedLotto;
    }
}
