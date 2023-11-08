package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Publishing {
    List<Integer> numbers;
    Lotto lotto;
    List<Lotto> lottos;
    private void createRandomNumber() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
    }

    public List<Lotto> publishLotto(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            createRandomNumber();
            lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
