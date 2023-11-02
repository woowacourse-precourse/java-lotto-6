package lotto;

import camp.nextstep.edu.missionutils.Randoms;
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

    public Lotto publish(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
