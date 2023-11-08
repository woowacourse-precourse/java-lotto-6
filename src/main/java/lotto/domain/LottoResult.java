package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class LottoResult {
    private static final int DEFAULT_VALUE = 0;
    private static final int _2ND_OR_3RD = 5;
    private static final int PRIZE_COUNT_INCREMENT = 1;
    private EnumMap<LottoPrize, Integer> lottoResult = new EnumMap<>(LottoPrize.class);

    public EnumMap<LottoPrize, Integer> getLottoResult() {
        return lottoResult;
    }

    public LottoResult(List<Lotto> userLottoTicket, WinningLottoNumbers winningLottoNumbers) {
        List<LottoPrize> userLottoPrizeResults = userLottoTicket.stream()
                .map(lotto -> calculateUserLottoPrize(lotto, winningLottoNumbers))
                .toList();
        this.lottoResult = calculateLottoResult(userLottoPrizeResults);
    }

    public long calculateTotalPrize() {
        return this.lottoResult.keySet().stream()
                .mapToLong(prize -> lottoResult.get(prize) * prize.getPrize().getMoney())
                .sum();
    }

    private EnumMap<LottoPrize, Integer> calculateLottoResult(List<LottoPrize> userLottoPrizeResults) {
        initializeLottoResult();
        userLottoPrizeResults.forEach(prize ->
                lottoResult.put(prize, lottoResult.getOrDefault(prize, DEFAULT_VALUE) + PRIZE_COUNT_INCREMENT));
        return lottoResult;
    }

    private void initializeLottoResult() {
        Arrays.stream(LottoPrize.values())
                .forEach(prize -> lottoResult.put(prize, DEFAULT_VALUE));
    }

    private LottoPrize calculateUserLottoPrize(Lotto lotto, WinningLottoNumbers winningLottoNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLottoNumbers.getWinningNumbers();
        List<Integer> matchingNumbers = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .toList();
        return determineLottoPrize(matchingNumbers.size(), winningLottoNumbers.getBonusNumber(), lottoNumbers);
    }

    private LottoPrize determineLottoPrize(int matchingCount, int bonusNumber, List<Integer> lottoNumbers) {
        if (matchingCount == _2ND_OR_3RD) {
            return LottoPrize.determine2ndOr3rdPrize(lottoNumbers, bonusNumber);
        }
        return LottoPrize.determinePrize(matchingCount);
    }
}