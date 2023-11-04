package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

public class LotteryStore {


    LottoFactory lottoFactory;

    public void getLottoOrderUpTo(int count) {
        List<Lotto> orderedLottos = createRandomLottoUpTo(count);

    }
    private List<Lotto> createRandomLottoUpTo(int count) {
        return IntStream.range(0, count)
                        .mapToObj(loopIndex -> lottoFactory.createRandomLotto())
                        .toList();
    }




}
