package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Constants;
import lotto.model.Lotto;
import lotto.model.LottoPrize;

public class LottoResultCalculator {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResultCalculator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoResult(List<Lotto> lottoTickets) {
        List<Integer> lottoResult = initializeLottoResult();

        for (Lotto lottoTicket : lottoTickets) {
            int lottoPrize = calculateLottoPrize(lottoTicket.getNumbers());
            updateLottoResult(lottoResult, lottoPrize);
        }
        return lottoResult;
    }

    private List<Integer> initializeLottoResult() {
        return new ArrayList<>(List.of(Constants.INITIAL_COUNT, Constants.INITIAL_COUNT, Constants.INITIAL_COUNT,
            Constants.INITIAL_COUNT, Constants.INITIAL_COUNT, Constants.INITIAL_COUNT));
    }

    private int calculateLottoPrize(List<Integer> lottoNumbers) {
        int winningNumberCount = countWinningNumber(lottoNumbers);
        boolean hasBonusNumber = hasBonusNumber(lottoNumbers);

        return determinePrizeLevel(winningNumberCount, hasBonusNumber);
    }

    private int countWinningNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean hasBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(this.bonusNumber);
    }

    private static int determinePrizeLevel(int winningNumberCount, boolean hasBonusNumber) {
        return switch (winningNumberCount) {
            case Constants.NUMBER_MATCH_SIX -> LottoPrize.FIRST.getPrizeRank();
            case Constants.NUMBER_MATCH_FIVE -> determineSecondOrThirdPrize(hasBonusNumber);
            case Constants.NUMBER_MATCH_FOUR -> LottoPrize.FOURTH.getPrizeRank();
            case Constants.NUMBER_MATCH_THREE -> LottoPrize.FIFTH.getPrizeRank();
            default -> LottoPrize.NOTHING.getPrizeRank();
        };
    }

    private static int determineSecondOrThirdPrize(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return LottoPrize.SECOND.getPrizeRank();
        }
        return LottoPrize.THIRD.getPrizeRank();
    }

    private static void updateLottoResult(List<Integer> lottoResult, int lottoPrize) {
        lottoResult.set(lottoPrize, lottoResult.get(lottoPrize) + Constants.INCREMENT_VALUE);
    }

}