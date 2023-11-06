package lotto.service;

import java.util.List;
import java.util.stream.Stream;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;
import lotto.domain.LottoWinning;
import lotto.repository.LottoRepository;
import lotto.repository.LottoWinningRepository;
import lotto.util.LottoGenerator;

public class LottoService {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoRepository lottoRepository = new LottoRepository();
    private final LottoWinningRepository lottoWinningRepository = new LottoWinningRepository();

    public void buyLotto(int purchaseAmount){
        int lottoCount = purchaseAmount / LottoConfig.LOTTO_BUYING_UNIT.getValue();

        List<Lotto> lottos = Stream
                .generate(lottoGenerator::generate)
                .limit(lottoCount)
                .sorted()
                .toList();

        lottoRepository.save(lottos);
    }

    public void saveWinningNumbers(List<Integer> winningNumbers, int bonusNumber){
        LottoWinning lottoWinning = new LottoWinning(new Lotto(winningNumbers), bonusNumber);

        lottoWinningRepository.save(lottoWinning);
    }

    public void calcLotto(){

    }
}
