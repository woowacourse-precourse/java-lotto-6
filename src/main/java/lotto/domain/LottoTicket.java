package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket() {
        this.lottos = new ArrayList<>();
    }

    public void generateLottoTicket(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public void printLottoTicket() {
        System.out.printf("%d개를 구매했습니다.", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
