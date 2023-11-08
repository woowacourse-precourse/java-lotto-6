package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.exception.CustomIllegalArgumentException;
import lotto.exception.ExceptionMessage;
import lotto.model.LottoTotalPrize;
import lotto.model.WinningLotto;
import lotto.model.constants.LottoWinningRank;

import java.util.Arrays;
import java.util.List;

public class LottoService {
    private final static int LOTTO_PRICE = 1000;
    private final static int MIN_AMOUNT = 1;
    private final static int BONUS_MATCHING_COUNT = 5;
    private final static int MIN_PRIZE_COUNT = 3;
    private final static int NO_PRIZE_COUNT = 0;

    public LottoTickets createLottoTickets(int amount) {
        int ticketCount = purchaseLottoCount(amount);

        return new LottoTickets(ticketCount);
    }

    public WinningLotto createWinningLotto(List<Integer> winNumbers, int bonusNumber) {
        return new WinningLotto(winNumbers, bonusNumber);
    }

    public LottoTotalPrize compareWinningNumbers(LottoTickets lottoTickets, WinningLotto winningLotto) {
        LottoTotalPrize lottoResult = new LottoTotalPrize();

        for (Lotto lotto : lottoTickets.getTickets()) {
            int prizeCount = compareWinningNumbers(lotto, winningLotto);
            LottoWinningRank rank = determinePrizeRank(prizeCount);

            if (rank.getMatchingNumbers() == BONUS_MATCHING_COUNT) {
                rank = compareBonusNumber(lotto, winningLotto.getBonusNumber());
            }

            lottoResult.prizeCountPlus(rank);
        }

        return lottoResult;
    }

    private int purchaseLottoCount(int amount) {
        validateLottoAmount(amount);

        return amount / LOTTO_PRICE;
    }

    private void validateLottoAmount(int amount) {
        if (amount % LOTTO_PRICE != 0 || amount < MIN_AMOUNT) {
            throw new CustomIllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT);
        }
    }

    private int compareWinningNumbers(Lotto lotto, WinningLotto winLotto) {
        return lotto.getNumbers()
                .stream()
                .filter(number ->
                        winLotto.getNumbers().contains(number))
                .toList()
                .size();
    }

    private LottoWinningRank determinePrizeRank(int prizeCount) {
        if (prizeCount < MIN_PRIZE_COUNT && prizeCount >= NO_PRIZE_COUNT) {
            return LottoWinningRank.NO_WINNER;
        }

        return Arrays.stream(LottoWinningRank.values())
                .filter(rank ->
                        rank.getMatchingNumbers() == prizeCount)
                .findFirst()
                .orElseThrow(() ->
                        new CustomIllegalArgumentException(ExceptionMessage.INVALID_PRIZE_COUNT));
    }

    private LottoWinningRank compareBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return LottoWinningRank.SECOND;
        }

        return LottoWinningRank.THIRD;
    }

    public Float calculateProfitability(LottoTickets lottoTickets, LottoTotalPrize lottoResult) {
        int amount = lottoTickets.getTickets().size() * LOTTO_PRICE;
        int totalPrize = calculateTotalPrize(lottoResult);
        float profit = (float) totalPrize / amount;

        return profit * 100;
    }

    private int calculateTotalPrize(LottoTotalPrize lottoResult) {
        return lottoResult.getPrizeCounts()
                .entrySet()
                .stream()
                .map(entry ->
                        entry.getKey().getPrize() * entry.getValue())
                .mapToInt(Integer::intValue)
                .sum();
    }
}
