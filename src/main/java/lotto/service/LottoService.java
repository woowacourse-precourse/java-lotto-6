package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;
import lotto.util.LottoGenerator;

public class LottoService {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void buyLotto(int purchaseAmount){
        int lottoCount = purchaseAmount / LottoConfig.LOTTO_BUYING_UNIT.getValue();

        List<Lotto> lottos = Stream
                .generate(lottoGenerator::generate)
                .limit(lottoCount)
                .sorted()
                .toList();
    }

    public void saveWinningNumbers(List<Integer> winningNumbers, int bonusNumber){

    }

    public void calcLotto(){

    }
}
