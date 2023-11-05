package lotto.domain;

import java.util.List;

public class Comparator {
    int numOfFirstPlace = 0;
    int numOfSecondPlace = 0;
    int numOfThirdPlace = 0;
    int numOfFourthPlace = 0;
    int numOfFifthPlace = 0;

    public void compare(List<Lotto> lottos, List<Integer> winnerNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = 0;
            List<Integer> list = lotto.getNumbers();
            for (int winNum : winnerNumbers) {
                if (list.contains(winNum)) {
                    matchCount++;
                }
            }

            if (matchCount == 6) {
                numOfFirstPlace++;
                continue;
            } else if (matchCount == 5 && list.contains(bonusNumber)) {
                numOfSecondPlace++;
                continue;
            } else if (matchCount == 5) {
                numOfThirdPlace++;
                continue;
            } else if (matchCount == 4) {
                numOfFourthPlace++;
                continue;
            } else if (matchCount == 3) {
                numOfFifthPlace++;
                continue;
            }
            continue;
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
