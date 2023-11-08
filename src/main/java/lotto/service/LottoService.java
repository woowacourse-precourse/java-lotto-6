package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.domain.LottoResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoService {
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public List<Lotto> purchaseLotto(int purchaseAmount){
        List<Lotto> purchasedLotto = new ArrayList<>();
        for(int i = 0 ; i < purchaseAmount;i++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
                    LOTTO_MINIMUM_NUMBER,
                    LOTTO_MAXIMUM_NUMBER,
                    LOTTO_NUMBERS_COUNT
            );
            Lotto generatedLotto = new Lotto(lottoNumbers);
            purchasedLotto.add(generatedLotto);
        }
        return purchasedLotto;
    }

    public List<LottoResult> calculateResult(List<Lotto> lottoTickets,
                                             List<Integer> winningLottoNumbers,
                                             int bonusNumber) {
        List<LottoResult> results = new ArrayList<>();
        for (Lotto ticket : lottoTickets) {
            int matchCount = 0;
            matchCount = getMatchCount(winningLottoNumbers, ticket, matchCount);
            boolean bonusMatch = (matchCount == 5) && ticket.getNumbers().contains(bonusNumber);
            results.add(LottoResult.valueOf(matchCount, bonusMatch));
        }
        return results;
    }

    private int getMatchCount(List<Integer> winningLottoNumbers, Lotto ticket, int matchCount) {
        for (int number : ticket.getNumbers()) {
            if (winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public double getEarningsRate(List<LottoResult> lottoResult,int purchaseAmount) {
        int totalPrizeMoney = calculatePrizeMoney(lottoResult);
        int totalInvestment = purchaseAmount*1000;
        return calculateEarningsRate(totalPrizeMoney,totalInvestment);
    }

    private double calculateEarningsRate(int totalPrizeMoney, int totalInvestment) {
        double earningsRate = (double) totalPrizeMoney / totalInvestment * 100;
        return Math.round(earningsRate * 10) / 10.0;

    }

    private int calculatePrizeMoney(List<LottoResult> lottoResult) {
        return lottoResult.stream()
                .mapToInt(LottoResult::getPrizeMoney)
                .sum();
    }

}
