package lotto.Domain;

import lotto.Validator.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final List<Lotto> userLottos;
    private final int lottoQuantity;

    public User(List<Lotto> userLottos, int lottoQuantity) {
        Validator.validateUserLottoCount(userLottos, lottoQuantity);
        this.userLottos = userLottos;
        this.lottoQuantity = lottoQuantity;
    }

    //각 등수의 갯수를 구하는 메소드
    public List<Integer> countTotalResult(List<Integer> lottoWinningNumbers, int bonusNumber) {
        Integer[] arr = {0,0,0,0,0,0};
        List<Integer> resultCount = new ArrayList<>(Arrays.asList(arr));
        for (Rank rank : findAllResult(lottoWinningNumbers, bonusNumber)) {
            resultCount.set(rank.ordinal(), resultCount.get(rank.ordinal()) + 1);
        }
        return resultCount;
    }

    private List<Rank> findAllResult(List<Integer> lottoWinningNumbers, int bonusNumber) {
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
        for (int i = 0; i < lottoQuantity; i++) {
            resultRanks.add(findRank(resultByWinningNumbers.get(i), resultByBonusNumber.get(i)));
        }
        return resultRanks;
    }

    private Rank findRank(int matchNumberCount, boolean matchBonusNumber) {
        return Rank.valueOf(matchNumberCount, matchBonusNumber);
    }

    public double calculateProfitRate(List<Integer> resultCount) {
        return TotalPrize(resultCount) / (this.lottoQuantity * 10.0);
    }

    private int TotalPrize(List<Integer> resultCount) {
        int resultPrizes = 0;
        for (Rank rank : Rank.values()) {
            resultPrizes += resultCount.get(rank.ordinal()) * rank.getPrize();
        }
        return resultPrizes;
    }
}