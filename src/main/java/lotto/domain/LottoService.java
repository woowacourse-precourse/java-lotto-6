package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoUtils.getMatchCount;

public class LottoService {
    private int numOfFirstPlace = 0;
    private int numOfSecondPlace = 0;
    private int numOfThirdPlace = 0;
    private int numOfFourthPlace = 0;
    private int numOfFifthPlace = 0;
    private static final int LOTTO_PRICE = 1000;

    public void compareAll(List<Lotto> lottoBundle, List<Integer> winnerNumbers, int bonusNumber) {
        for (Lotto lotto : lottoBundle) {
            compare(winnerNumbers, bonusNumber, lotto);
        }
    }

    private void compare(List<Integer> winningNumbers, int bonusNumber, Lotto lotto) {
        List<Integer> list = lotto.getNumbers();
        int matchCount = getMatchCount(winningNumbers, list);
        checkIfWinFirstPlace(matchCount, list, bonusNumber);
    }

    public Map<LottoRank, Integer> getWinningResults(List<Lotto> lottoBundle, WinningNumbers winningNumbers) {
        // init
        Map<LottoRank, Integer> winningResults = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            winningResults.put(lottoRank, 0);
        }

        // getWinningResults
        for (Lotto lotto : lottoBundle) {
            LottoRank lottoRank = LottoRank.valueOf(lotto, winningNumbers);
            winningResults.put(lottoRank, winningResults.get(lottoRank) + 1);
        }

        return winningResults;
    }

    public long calculateTotalPrize(Map<LottoRank, Integer> getWinningResults) {
        long totalPrize = 0L;
        for (LottoRank lottoRank : getWinningResults.keySet()) {
            totalPrize += lottoRank.getPrize() * getWinningResults.get(lottoRank);
        }
        return totalPrize;
    }

    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void checkIfWinFirstPlace(int matchCount, List<Integer> list, int bonusNumber) {
        if (matchCount == 6) {
            numOfFirstPlace++;
            return;
        }
        checkIfWinSecondPlace(matchCount, list, bonusNumber);
    }

    private void checkIfWinSecondPlace(int matchCount, List<Integer> list, int bonusNumber) {
        if (matchCount == 5 && list.contains(bonusNumber)) {
            numOfSecondPlace++;
            return;
        }
        checkIfWinThirdPlace(matchCount, list, bonusNumber);
    }

    private void checkIfWinThirdPlace(int matchCount, List<Integer> list, int bonusNumber) {
        if (matchCount == 5) {
            numOfThirdPlace++;
            return;
        }
        checkIfWinFourthPlace(matchCount, list, bonusNumber);
    }

    private void checkIfWinFourthPlace(int matchCount, List<Integer> list, int bonusNumber) {
        if (matchCount == 4) {
            numOfFourthPlace++;
            return;
        }
        getCheckIfWinFifthPlace(matchCount, list, bonusNumber);
    }

    private void getCheckIfWinFifthPlace(int matchCount, List<Integer> list, int bonusNumber) {
        if (matchCount == 3) {
            numOfFifthPlace++;
        }
    }

    public int getNumOfFirstPlace() {
        return numOfFirstPlace;
    }

    public int getNumOfSecondPlace() {
        return numOfSecondPlace;
    }

    public int getNumOfThirdPlace() {
        return numOfThirdPlace;
    }

    public int getNumOfFourthPlace() {
        return numOfFourthPlace;
    }

    public int getNumOfFifthPlace() {
        return numOfFifthPlace;
    }
}
