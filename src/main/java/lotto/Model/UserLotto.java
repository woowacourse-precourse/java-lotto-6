package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserLotto {
    List<Lotto> userLottos = new ArrayList<>();

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Lotto> userLottosCreate(int amount) {

        while (userLottos.size() < amount) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
            Collections.sort(randomNumbers);
            userLottos.add(new Lotto(randomNumbers));
        }

        return new ArrayList<>(userLottos);
    }

}
