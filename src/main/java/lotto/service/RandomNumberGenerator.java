package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class RandomNumberGenerator {

    public List<Lotto> generateRandomNumber(int userPurchase) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < userPurchase; i++) {
            List<Integer> numbers = getRandomNumber();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            System.out.println(lotto);
        }
        return lottos;
    }

    private List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
