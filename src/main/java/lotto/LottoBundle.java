package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    private final List<Lotto> bundle = new ArrayList<>();

    public List<Lotto> getBundle() {
        return bundle;
    }

    public void makeLotto(String input) {
        Validation.price(input);
        int quantity = Integer.parseInt(input) / Config.UNIT;
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Config.MIN, Config.MAX, Config.LOTTO_LENGTH);
            bundle.add(new Lotto(numbers));
        }
    }
}