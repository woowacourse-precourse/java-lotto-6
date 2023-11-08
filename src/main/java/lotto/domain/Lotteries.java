package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotteries {

    public List<Lotto> BuyLotteries(int purchaseAmount) {
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            lotteries.add(Buy());
        }

        return lotteries;
    }


    private Lotto Buy() {
        List<Integer> LottoNumberList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        LottoNumberList = LottoNumberList.stream().
                sorted().
                collect(Collectors.toList());

        return new Lotto(LottoNumberList);
    }

}
