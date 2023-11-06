package lotto.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class UserLotto {

    private int lottoCount;
    private List<Lotto> lottos;

    private void moneyToLotto(int money) {
        this.lottoCount = money / 1000;
    }

    private Lotto publishLotto() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new Lotto(numbers);
    }
}
