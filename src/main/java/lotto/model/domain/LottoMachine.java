package lotto.model.domain;

import static lotto.util.Constants.MAX_NUMBER;
import static lotto.util.Constants.MIN_NUMBER;
import static lotto.util.Constants.NUMBERS_SIZE;

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
                new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE));
            Collections.sort(numbers);
            issuedLotto.add(new Lotto(numbers));
            init++;
        }
    }

    public List<Lotto> getIssuedLotto() {
        return this.issuedLotto;
    }
}
