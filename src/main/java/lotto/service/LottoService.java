package lotto.service;

import lotto.constant.LottoWinningRank;
import lotto.domain.*;
import lotto.dto.LottoNumbers;
import lotto.dto.LottoWinningResult;
import lotto.repository.LottoRepository;
import lotto.util.ReturnRateCountUtil;

import java.util.List;
import java.util.function.Function;

public class LottoService {

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public List<LottoNumbers> buyLotto(LottoBuyPrice lottoBuyPrice) {
        List<Lotto> createdLottos = createLotto(lottoBuyPrice);

        return convertLottoToLottoNumbers(createdLottos);
    }

    private List<Lotto> createLotto(LottoBuyPrice lottoBuyPrice) {
        List<Lotto> createdLottos = LottoFactory.createLotto(lottoBuyPrice);
        lottoRepository.saveAll(createdLottos);

        return createdLottos;
    }

    private List<LottoNumbers> convertLottoToLottoNumbers(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> new LottoNumbers(lotto.getNumbers()))
                .toList();
    }

    public LottoWinningResult checkLottoWinningResult(LottoWinningNumber winningNumber, LottoBonusNumber bonusNumber) {
        List<Lotto> lottos = lottoRepository.getAll();

        List<LottoWinningRank> lottoWinningRanks = checkLottoWinningRank(
                lottos,
                winningNumber,
                bonusNumber
        );
        double totalReturnRate = countTotalReturnRate(lottoWinningRanks);

        return new LottoWinningResult(lottoWinningRanks, totalReturnRate);
    }

    private List<LottoWinningRank> checkLottoWinningRank(
            List<Lotto> lottos,
            LottoWinningNumber winningNumber,
            LottoBonusNumber bonusNumber
    ) {
        Function<Lotto, LottoWinningRank> checkLottoWinningRankProcess = lotto -> {
            int equalNumberCount = winningNumber.equalLottoNumbersWithWinningNumbers(lotto);
            boolean hasBonusNumber = bonusNumber.checkLottoHasBonusNumber(lotto);

            return LottoWinningRank.checkWinningResult(equalNumberCount, hasBonusNumber);
        };

        return lottos.stream()
                .map(checkLottoWinningRankProcess)
                .toList();
    }

    private double countTotalReturnRate(List<LottoWinningRank> lottoWinningRanks) {
        int totalWinningAmount = countTotalWinningAmount(lottoWinningRanks);
        int lottoBuyPrice = LottoBuyPrice.countTotalLottoPrice(lottoWinningRanks.size());

        return ReturnRateCountUtil.countReturnRate(totalWinningAmount, lottoBuyPrice);
    }

    private int countTotalWinningAmount(List<LottoWinningRank> lottoWinningRanks) {
        return lottoWinningRanks.stream()
                .mapToInt(LottoWinningRank::getWinningAmount)
                .sum();
    }
}
