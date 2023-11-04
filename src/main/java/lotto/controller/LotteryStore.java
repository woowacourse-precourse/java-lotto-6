package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRepository;
import lotto.domain.Money;

public class LotteryStore {


    LottoFactory lottoFactory;
    LottoRepository lottoRepository;

    public void getLottoOrderUpTo(int count) {
        List<Lotto> orderedLottos = lottoFactory.createRandomLottoUpto(count);
        lottoRepository.saveAll(orderedLottos);
    }







}
