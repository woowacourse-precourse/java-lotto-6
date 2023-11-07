package lotto.domain;

import java.util.List;

public class LottoService {
    private int numOfFirstPlace = 0;
    private int numOfSecondPlace = 0;
    private int numOfThirdPlace = 0;
    private int numOfFourthPlace = 0;
    private int numOfFifthPlace = 0;

    public void compare(List<Lotto> lottoBundle, List<Integer> winnerNumbers, int bonusNumber) {
        for (Lotto lotto : lottoBundle) {
            List<Integer> list = lotto.getNumbers();
            int matchCount = getMatchCount(winnerNumbers, list);
            checkIfWinFirstPlace(matchCount, list, bonusNumber);
        }
    }

    private int getMatchCount(List<Integer> winnerNumbers, List<Integer> list) {
        int matchCount = 0;
        for (int winNum : winnerNumbers) {
            if (list.contains(winNum)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public void checkIfWinFirstPlace(int matchCount, List<Integer> list, int bonusNumber) {
        if (matchCount == 6) {
            numOfFirstPlace++;
            return;
        }
        checkIfWinSecondPlace(matchCount, list, bonusNumber);
    }

    public void checkIfWinSecondPlace(int matchCount, List<Integer> list, int bonusNumber) {
        if (matchCount == 5 && list.contains(bonusNumber)) {
            numOfSecondPlace++;
            return;
        }
        checkIfWinThirdPlace(matchCount, list, bonusNumber);
    }

    public void checkIfWinThirdPlace(int matchCount, List<Integer> list, int bonusNumber) {
        if (matchCount == 5) {
            numOfThirdPlace++;
            return;
        }
        checkIfWinFourthPlace(matchCount, list, bonusNumber);
    }

    public void checkIfWinFourthPlace(int matchCount, List<Integer> list, int bonusNumber) {
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


    public long getProfit() {
        long profit = 0;
        profit += numOfFirstPlace * 2_000_000_000L;
        profit += numOfSecondPlace * 30_000_000L;
        profit += numOfThirdPlace * 1_500_000L;
        profit += numOfFourthPlace * 50_000L;
        profit += numOfFifthPlace * 5_000L;

        return profit;
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
