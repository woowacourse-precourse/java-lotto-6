package Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(int num) {
        lottos = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
