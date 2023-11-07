package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int ZERO = 0;
    private static final int MIN_NUMBER = 1;
    private static final int SIZE = 6;
    private static final int MAX_NUMBER = 45;
    private final List<Lotto> lottos;

    public Lottos(int TicketCount) {
        this.lottos = createLottos(TicketCount);
    }

    private List<Lotto> createLottos(int TicketCount) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = ZERO; i < TicketCount; i++) {
            lotto.add(createLottoNumber());
        }
        return lotto;
    }

    private Lotto createLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE);
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
