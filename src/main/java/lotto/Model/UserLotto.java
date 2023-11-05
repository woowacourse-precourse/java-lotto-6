package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserLotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int AMOUNT = 6;

    public List<Lotto> userLottosCreate(int amount) {
        List<Lotto> userLottosSet = new ArrayList<>();

        while (userLottosSet.size() < amount) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, AMOUNT));
            Collections.sort(randomNumbers);
            userLottosSet.add(new Lotto(randomNumbers));
        }

        return new ArrayList<>(userLottosSet);
    }

}
