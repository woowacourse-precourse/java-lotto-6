package lotto.service;

import lotto.constant.LottoWinningRank;
import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoBuyPrice;
import lotto.domain.LottoWinningNumber;
import lotto.dto.LottoNumbers;
import lotto.dto.LottoWinningResult;
import lotto.repository.LottoRepository;
import lotto.util.RandomNumberUtil;
import lotto.util.ReturnRateCountUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LottoService {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public List<LottoNumbers> buyLotto(LottoBuyPrice lottoBuyPrice) {
        int availableLottoBuyCount = lottoBuyPrice.getAvailableLottoBuyCount();
        List<Lotto> createdLottos = createAndSaveLotto(availableLottoBuyCount);

        return convertLottoToLottoNumbers(createdLottos);
    }

    private List<Lotto> createAndSaveLotto(int createCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < createCount; i++) {
            List<Integer> numbers = RandomNumberUtil.generateAndSortUniqueNumbersInRange(
                    LOTTO_START_NUMBER,
                    LOTTO_END_NUMBER,
                    LOTTO_NUMBER_COUNT
            );
            lottos.add(new Lotto(numbers));
        }

        lottoRepository.saveAll(lottos);

        return lottos;
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
