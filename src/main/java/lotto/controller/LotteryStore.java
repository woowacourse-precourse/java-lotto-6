package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoRepository;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.dto.PurchasedLottosDto;
import lotto.service.RankCalculateService;

public class LotteryStore {


    LottoFactory lottoFactory = new LottoFactory();
    LottoRepository lottoRepository = LottoRepository.getInstance();
    RankCalculateService rankCalculateService = new RankCalculateService();

    public void getLottoOrderUpTo(int count) {
        List<Lotto> orderedLottos = lottoFactory.createRandomLottoUpto(count);

        lottoRepository.saveAll(orderedLottos);
    }

    public PurchasedLottosDto showPurchasedLottos() {
        List<Lotto> purchasedLottos = lottoRepository.showAllLottos();
        List<List<Integer>> Lottos = purchasedLottos.stream()
                                                    .map(Lotto::showNumbersByIntegers)
                                                    .toList();

        return PurchasedLottosDto.from(Lottos);
    }

    public WinningStatistics calculateStatistics() {
        List<Rank> ranks = rankCalculateService.calculateRanks();
        return WinningStatistics.from(ranks);
    }

    public void decideWinningLottoFrom(List<String> winningLottoNumbers, String bonusNumber) {
        WinningLotto winningLotto = lottoFactory.createWinningLottoFrom(winningLottoNumbers, bonusNumber);
        lottoRepository.save(winningLotto);
    }


}
