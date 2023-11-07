package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int TicketCount) {
        this.lottos = createLottos(TicketCount);
    }

    private List<Lotto> createLottos(int TicketCount) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < TicketCount; i++) {
            lotto.add(createLottoNumber());
        }
        return lotto;
    }

    private Lotto createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Lotto lotto : lottos) {
            result.append(lotto.toString()).append("\n");
        }
        return result.toString();
    }
}
