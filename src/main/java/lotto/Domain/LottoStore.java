package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoStore {
    public List<Lotto> generateLotto(int quantity) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        for(int i=0; i<quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLotto.add(new Lotto(numbers));
        }
        return purchasedLotto;
    }
}
