package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.GameNumber;
import lotto.domain.Lotto;

public class GameService {
    public List<Lotto> makeLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            lottos.add(new Lotto(makeLotto()));
        }

        return lottos;
    }

    private List<Integer> makeLotto() {
        List<Integer> numbers = new ArrayList<>();
        int count = GameNumber.NUMBERS_PER_LOTTO.getNumber();
        int number = 0;

        while (count > 0) {
            number = Randoms.pickNumberInRange(1, 45);

            if (numbers.contains(number))
                continue;

            numbers.add(number);
            count--;
        }

        Collections.sort(numbers);

        return numbers;
    }

}
