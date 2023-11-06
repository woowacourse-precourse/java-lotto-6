package lotto.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class UserLotto {

    private int lottoCount;
    private List<Lotto> lottos;

    private void moneyToCount(int money) {
        this.lottoCount = money / 1000;
    }

    private void publishLottoBundle() {
        lottos = new ArrayList<>();
        Lotto newLotto;

        for(int i = 0; i < lottoCount; i++) {
            newLotto = publishLotto();
            lottos.add(newLotto);
        }
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
