package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameService {

    public List<Lotto> buyLottosWithBudget(Integer budget) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < calculatePurchaseQuantity(budget); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers.stream().sorted().toList()));
        }

        return lottos;
    }

    private Integer calculatePurchaseQuantity(Integer budget) {
        return budget / Lotto.PRICE;
    }

}
