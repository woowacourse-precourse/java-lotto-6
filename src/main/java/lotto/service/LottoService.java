package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.LottoResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> buyLottoTickets(int purchaseAmount) {
        int numberOfLottoTicketsToBuy = calculateNumberOfLottoTicketsToBuy(purchaseAmount);
        return generateLottoTickets(numberOfLottoTicketsToBuy);
    }

    public int calculateNumberOfLottoTicketsToBuy(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public List<Lotto> generateLottoTickets(int numberOfTickets) {
        return Stream.generate(() -> generateUniqueLottoTicket())
                .limit(numberOfTickets)
                .collect(Collectors.toList());
    }

    private Lotto generateUniqueLottoTicket() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
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
            LottoPrize lottoPrize = getLottoPrize(rank);
            lottoResult.addResult(lottoPrize, 1);
        }
        return lottoResult;
    }

    private int calculateRank(int matchCount, boolean isContainBonusNumber) {
        int rank = 0;

        if (matchCount == 6) {
            rank = 1;
        }
        if (matchCount == 5 && isContainBonusNumber) {
            rank = 2;
        }
        if (matchCount == 5 && !isContainBonusNumber) {
            rank = 3;
        }
        if (matchCount == 4) {
            rank = 4;
        }
        if (matchCount == 3) {
            rank = 5;
        }
        return rank;
    }

    private boolean isContainBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int calculateMatchCount(List<Integer> winningNumbers, Lotto lotto) {
        int count = 0;
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (winningNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    public LottoPrize getLottoPrize(int rank) {
        LottoPrize result = LottoPrize.NOTHING_MATCH;
        if (rank == 1) {
            result = LottoPrize.FIRST_PRIZE;
        }
        if (rank == 2) {
            result = LottoPrize.SECOND_PRIZE;
        }
        if (rank == 3) {
            result = LottoPrize.THIRD_PRIZE;
        }
        if (rank == 4) {
            result = LottoPrize.FOURTH_PRIZE;
        }
        if (rank == 5) {
            result = LottoPrize.FIFTH_PRIZE;
        }
        return result;
    }

    public Double computeProfitRate(int purchaseAmount, int profit) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        double profitRate = ((double) profit / purchaseAmount) * 100;
        return Math.round(profitRate * 10.0) / 10.0;
    }
}
