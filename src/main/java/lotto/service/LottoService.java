package lotto.service;

import lotto.domain.*;
import lotto.repository.LottoRepository;

import java.util.List;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService() {
        this.lottoRepository = new LottoRepository();
    }

    public List<Lotto> buyLotto(Integer purchaseAmount) {
        List<Lotto> lottos = LottoMachine.generateLottoByPurchaseAmount(purchaseAmount);
        lottoRepository.save(lottos);
        return lottos;
    }

    public WinningStatistics generateStatistics(List<Prize> winPrizes) {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.acceptWinPrizes(winPrizes);
        return winningStatistics;
    }

    public List<Prize> calculateTotalPrizes(List<Integer> winningNumbers, Integer bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
        List<Lotto> lottos = lottoRepository.findAll();
        return calculatePrize(lottos, winningLotto);
    }

    private List<Prize> calculatePrize(List<Lotto> lottos, WinningLotto winningLotto) {
        return lottos.stream().map(lotto -> {
            int matchNumber = winningLotto.compareLotto(lotto);
            boolean isBonusNumberMatch = winningLotto.compareBonusNumber(lotto);
            return Prize.getPrizeByMatchCount(matchNumber, isBonusNumberMatch);
        }).toList();
    }
}
