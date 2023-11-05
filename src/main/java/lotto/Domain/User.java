package lotto.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private List<Lotto> userLottos;

    public User(List<Lotto> userLottos) {
        this.userLottos = userLottos;
    }

    public List<Rank> findAllResult(List<Integer> lottoWinningNumbers, int bonusNumber) {
        List<Integer> resultByWinningNumbers = findAllResultByWinnungNumbers(lottoWinningNumbers);
        List<Boolean> resultByBonusNumber = findAllResultByBonusNumber(bonusNumber);
        List<Rank> resultRanks = findAllRank(resultByWinningNumbers, resultByBonusNumber);
        return resultRanks;
    }

    private List<Integer> findAllResultByWinnungNumbers(List<Integer> lottoWinningNumbers) {
        List<Integer> resultByWinningNumbers = new ArrayList<>();
        for (Lotto lotto : this.userLottos) {
            resultByWinningNumbers.add(lotto.calculateLottoResults(lottoWinningNumbers));
        }
        return resultByWinningNumbers;
    }

    private List<Boolean> findAllResultByBonusNumber(int bonusNumber) {
        List<Boolean> resultByBonusNumber = new ArrayList<>();
        for (Lotto lotto : this.userLottos) {
            resultByBonusNumber.add(lotto.bonusNumberCheck(bonusNumber));
        }
        return resultByBonusNumber;
    }

    private List<Rank> findAllRank(List<Integer> resultByWinningNumbers, List<Boolean> resultByBonusNumber) {
        List<Rank> resultRanks = new ArrayList<>();
        for (int i = 0; i < resultByWinningNumbers.size(); i++) {
            resultRanks.add(findRank(resultByWinningNumbers.get(i), resultByBonusNumber.get(i)));
        }
        return resultRanks;
    }

    private Rank findRank(int matchNumberCount, boolean matchBonusNumber) {
        return Rank.valueOf(matchNumberCount, matchBonusNumber);
    }
    
    public List<Integer> countTotalResult(List<Rank> resultRanks) {
        Integer[] arr = {0,0,0,0,0,0};
        List<Integer> resultCount = new ArrayList<>(Arrays.asList(arr));
        for (Rank rank : resultRanks) {
            resultCount.set(rank.ordinal(), resultCount.get(rank.ordinal()) + 1);
        }
        return resultCount;
    }

    public int TotalPrize(List<Integer> resultCount) {
        int resultPrizes = 0;
        for (Rank rank : Rank.values()) {
            resultPrizes += resultCount.get(rank.ordinal()) * rank.getPrize();
        }
        return resultPrizes;
    }
}