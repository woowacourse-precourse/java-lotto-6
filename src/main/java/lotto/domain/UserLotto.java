package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    private List<Lotto> lottoTickets;

    private UserLotto(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public static UserLotto makeRandomLotto(int cnt) {
        List<Lotto> randomLottoTickets = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            randomLottoTickets.add(new Lotto(makeRandomNumbers()));
        }
        return new UserLotto(randomLottoTickets);
    }

    private static List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
