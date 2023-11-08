package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseManager {

    public static final int PRICE_OF_LOTTO = 1000;

    public int calculateNumOfLotto(int purchaseAmount) {
        if (purchaseAmount % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + PRICE_OF_LOTTO + "원으로 나누어 떨어져야 합니다.");
        }
        return purchaseAmount / PRICE_OF_LOTTO;
    }

    public List<Lotto> createLottos(int numOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<numOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            try{
                lottos.add(new Lotto(numbers));
            } catch (IllegalArgumentException e) {
                i--;
            }
        }
        return lottos;
    }

}
