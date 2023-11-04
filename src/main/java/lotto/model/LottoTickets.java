package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> tickets = new ArrayList<>();

    public LottoTickets(int count) {
        buyLotto(count);
    }

    public void buyLotto(int count) {
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(generateLottoNumbers()));
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> randomNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNum);
        return randomNum;
    }
}
