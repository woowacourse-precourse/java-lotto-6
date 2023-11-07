package lotto.domain;

import static lotto.domain.Lotto.*;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void inssuance(Integer purchaseAmount) {
        Integer lottoCount = purchaseAmount % PRICE;
        for (int count=1; count<=lottoCount; count++){
            List<Integer> numbers = pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_LENGTH);
            lottos.add(new Lotto(numbers));
        }
    }
}
