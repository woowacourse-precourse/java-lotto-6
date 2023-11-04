package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> issuedLotto;
    private final int lottoTicket;


    public LottoMachine(int lottoTicket) {
        this.issuedLotto = new ArrayList<>();
        this.lottoTicket = lottoTicket;
    }

    public void issueTickets() {
        int init = 1;
        while(init <= lottoTicket) {
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

    public int getLottoPrice() {
        return lottoTicket * 1000;
    }
}
