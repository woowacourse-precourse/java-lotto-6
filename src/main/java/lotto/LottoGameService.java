package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGameService {

    private List<Lotto> lottos = new ArrayList<>();

    public void buyLottosWithBudget(Integer budget) {
        for (int i = 0; i < calculatePurchaseQuantity(budget); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers.stream().sorted().toList()));
        }
    }

    private Integer calculatePurchaseQuantity(Integer budget) {
        return budget / Lotto.PRICE;
    }

    public Integer getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
