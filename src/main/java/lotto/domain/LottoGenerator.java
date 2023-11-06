package lotto.domain;

import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public Lottos buyLottos(LottoPurchase lottoPurchase) {
        int count = lottoPurchase.getCount();
        return new Lottos(IntStream.range(0, count)
                .mapToObj(lotto -> createLotto())
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private Lotto createLotto() {
        List<Integer> randomNumber = RandomUtil.createRandomNumber();
        return new Lotto(randomNumber);
    }
}
