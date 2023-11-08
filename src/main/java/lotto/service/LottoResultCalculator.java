package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoResultCalculator {

    private static final int INITIAL_COUNT = 0;
    private static final int NUMBER_MATCH_SIX = 6;
    private static final int NUMBER_MATCH_FIVE = 5;
    private static final int NUMBER_MATCH_FOUR = 4;
    private static final int NUMBER_MATCH_THREE = 3;
    private static final int NO_WINNING = 0;
    private static final int FIRST_PRIZE = 1;
    private static final int SECOND_PRIZE = 2;
    private static final int THIRD_PRIZE = 3;
    private static final int FOURTH_PRIZE = 4;
    private static final int FIFTH_PRIZE = 5;
    public static final int INCREMENT_VALUE = 1;

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
        return new ArrayList<>(List.of(INITIAL_COUNT, INITIAL_COUNT, INITIAL_COUNT,
            INITIAL_COUNT, INITIAL_COUNT, INITIAL_COUNT));
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
            case NUMBER_MATCH_SIX -> FIRST_PRIZE;
            case NUMBER_MATCH_FIVE -> determineSecondOrThirdPrize(hasBonusNumber);
            case NUMBER_MATCH_FOUR -> FOURTH_PRIZE;
            case NUMBER_MATCH_THREE -> FIFTH_PRIZE;
            default -> NO_WINNING;
        };
    }

    private static int determineSecondOrThirdPrize(boolean hasBonusNumber) {
        if (hasBonusNumber) {
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }

    private static void updateLottoResult(List<Integer> lottoResult, int lottoPrize) {
        lottoResult.set(lottoPrize, lottoResult.get(lottoPrize) + INCREMENT_VALUE);
    }

}