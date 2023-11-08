package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoConstants;
import lotto.model.LottoManager;
import lotto.model.LottoResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    public List<Lotto> buyLottoTickets(int purchaseAmount) {
        int numberOfLottoTicketsToBuy = calculateNumberOfLottoTicketsToBuy(purchaseAmount);
        return generateLottoTickets(numberOfLottoTicketsToBuy);
    }

    public int calculateNumberOfLottoTicketsToBuy(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE;
    }

    public List<Lotto> generateLottoTickets(int numberOfTickets) {
        return Stream.generate(() -> generateUniqueLottoTicket())
                .limit(numberOfTickets)
                .collect(Collectors.toList());
    }

    private Lotto generateUniqueLottoTicket() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_START_NUMBER, LottoConstants.LOTTO_END_NUMBER, LottoConstants.LOTTO_NUMBER_COUNT);
        return new Lotto(lottoNumbers);
    }

    public LottoResult calculateLottoResult(LottoManager lottoManager, List<Lotto> lottoList) {
        List<Integer> winningNumbers = lottoManager.getWinningNumbers();
        int bonusNumber = lottoManager.getBonusNumber();
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottoList) {
            int matchCount = calculateMatchCount(winningNumbers, lotto);
            boolean isContainBonusNumber = isContainBonusNumber(lotto, bonusNumber);
            int rank = calculateRank(matchCount, isContainBonusNumber);
            LottoPrizeMessage lottoPrizeMessage = getLottoPrize(rank);
            lottoResult.addResult(lottoPrizeMessage, 1);
        }
        return lottoResult;
    }

    private int calculateMatchCount(List<Integer> winningNumbers, Lotto lotto) {
        int count = LottoConstants.MATCH_COUNT_START;
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private int calculateRank(int matchCount, boolean isContainBonusNumber) {
        int rank = LottoConstants.START_RANK;
        if (matchCount == LottoConstants.MATCH_SIX) rank = LottoConstants.FIRST_RANK;
        if (matchCount == LottoConstants.MATCH_FIVE && isContainBonusNumber) rank = LottoConstants.SECOND_RANK;
        if (matchCount == LottoConstants.MATCH_FIVE && !isContainBonusNumber) rank = LottoConstants.THIRD_RANK;
        if (matchCount == LottoConstants.MATCH_FOUR) rank = LottoConstants.FOURTH_RANK;
        if (matchCount == LottoConstants.MATCH_THREE) rank = LottoConstants.FIFTH_RANK;
        return rank;
    }

    private boolean isContainBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public LottoPrizeMessage getLottoPrize(int rank) {
        LottoPrizeMessage result = LottoPrizeMessage.NOTHING_MATCH;
        if (rank == LottoConstants.FIRST_RANK) result = LottoPrizeMessage.FIRST_PRIZE;
        if (rank == LottoConstants.SECOND_RANK) result = LottoPrizeMessage.SECOND_PRIZE;
        if (rank == LottoConstants.THIRD_RANK) result = LottoPrizeMessage.THIRD_PRIZE;
        if (rank == LottoConstants.FOURTH_RANK) result = LottoPrizeMessage.FOURTH_PRIZE;
        if (rank == LottoConstants.FIFTH_RANK) result = LottoPrizeMessage.FIFTH_PRIZE;
        return result;
    }

    public Double computeProfitRate(int purchaseAmount, int profit) {
        if (purchaseAmount == LottoConstants.PURCHASE_AMOUNT_ZERO) return LottoConstants.PROFIT_ZERO;
        double profitRate = ((double) profit / purchaseAmount) * 100;
        return Math.round(profitRate * LottoConstants.ROUND_FACTOR) / LottoConstants.ROUND_FACTOR;
    }
}
