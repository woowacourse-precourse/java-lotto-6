package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Publishing {
    List<Integer> numbers;
    Lotto[] lotto;
    private void createRandomNumber() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
    }

    public void publishLotto(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            createRandomNumber();
            lotto[i] = new Lotto(numbers);
        }
    }
}
