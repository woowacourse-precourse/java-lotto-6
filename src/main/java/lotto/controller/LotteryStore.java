package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRepository;
import lotto.domain.Money;
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
        List<String> purchasedLottos = lottoRepository.showAllLottos()
                .stream()
                .map(Lotto::toString)
                .toList();

        return PurchasedLottosDto.from(purchasedLottos);
    }

    public WinningStatistics calculateStatisticsWith(WinningLotto winningLotto) {
        List<Lotto> lottos = lottoRepository.showAllLottos();
        List<Rank> ranks = rankCalculateService.calculateRanksFrom(lottos, winningLotto);
        return WinningStatistics.from(ranks);
    }


}
