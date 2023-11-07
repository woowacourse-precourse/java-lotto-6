package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.RandomLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    private final RandomLottoGenerator lottoGenerator;

    public LottoService(RandomLottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buyLotto(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(lottoGenerator.generate()))
                .collect(Collectors.toList());
    }
}
