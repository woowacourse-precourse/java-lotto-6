package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.constant.LottoConstant;

public class LottoShop {

    public List<Lotto> buy(int money) {
        int count = money / LottoConstant.LOTTO_PRICE;
        return IntStream.range(0, count)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_FIRST_NUMBER,
                LottoConstant.LOTTO_LAST_NUMBER,
                LottoConstant.LOTTO_NUMBER_COUNT);
        return new Lotto(numbers);
    }
}
