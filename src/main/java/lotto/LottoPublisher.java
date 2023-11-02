package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoPublisher {
    private static LottoPublisher instance;

    private LottoPublisher() {

    }

    public static LottoPublisher getInstance() {
        if (instance == null) {
            instance = new LottoPublisher();
        }
        return instance;
    }

    private Lotto publish() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.comparingInt(o -> o));
        return new Lotto(numbers);
    }

    public List<Lotto> sell(long money) throws IllegalArgumentException {
        validateMoney(money);
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < money; i += Prize.TICKET_PRICE.getMoney()) {
            lottos.add(publish());
        }
        return lottos;
    }

    private void validateMoney(long money) throws IllegalArgumentException {
        if (money % Prize.TICKET_PRICE.getMoney() != 0 || money < 0) {
            throw new IllegalArgumentException();
        }
    }
}
