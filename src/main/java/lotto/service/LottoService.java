package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.*;

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

    public Map<LottoResult, Integer> calculateResult(List<Lotto> lottoTickets,
                                                     List<Integer> winningLottoNumbers,
                                                     int bonusNumber) {
        List<LottoResult> results = new ArrayList<>();
        for (Lotto ticket : lottoTickets) {
            int matchCount = 0;
            matchCount = getMatchCount(winningLottoNumbers, ticket, matchCount);
            boolean bonusMatch = (matchCount == 5) && ticket.getNumbers().contains(bonusNumber);
            results.add(LottoResult.valueOf(matchCount, bonusMatch));
        }
        return countResults(results);
    }

    private Map<LottoResult, Integer> countResults(List<LottoResult> results) {
        Map<LottoResult, Integer> resultCount = new EnumMap<>(LottoResult.class);

        for (LottoResult result : results) {
            resultCount.put(result, resultCount.getOrDefault(result, 0) + 1);
        }

        return resultCount;
    }

    private int getMatchCount(List<Integer> winningLottoNumbers, Lotto ticket, int matchCount) {
        for (int number : ticket.getNumbers()) {
            if (winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public double getEarningsRate(Map<LottoResult, Integer> lottoResult,int purchaseAmount) {
        int totalPrizeMoney = calculatePrizeMoney(lottoResult);
        int totalInvestment = purchaseAmount*1000;
        return calculateEarningsRate(totalPrizeMoney,totalInvestment);
    }

    private double calculateEarningsRate(int totalPrizeMoney, int totalInvestment) {
        double earningsRate = (double) totalPrizeMoney / totalInvestment * 100;
        return Math.round(earningsRate * 10) / 10.0;

    }

    private int calculatePrizeMoney(Map<LottoResult, Integer> lottoResult) {
        return lottoResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

}
