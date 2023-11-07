package lotto.domain.generator;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;

public class LottoGenerator {
    private final static RandomLottoNumbers randomLottoNumbers = new RandomLottoNumbers();

    public List<Lotto> createLottoList(LottoMoney lottoMoney){
        int lottoCount = lottoMoney.getLottoCount();
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> createLotto())
                .toList();
    }

    private Lotto createLotto() {
        return new Lotto(randomLottoNumbers.getValue());
    }

}
