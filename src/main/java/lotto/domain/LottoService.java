package lotto.domain;

import java.util.List;

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

    private void compare(List<Integer> winnerNumbers, int bonusNumber, Lotto lotto) {
        List<Integer> list = lotto.getNumbers();
        int matchCount = getMatchCount(winnerNumbers, list);
        checkIfWinFirstPlace(matchCount, list, bonusNumber);
    }

    private int getMatchCount(List<Integer> winnerNumbers, List<Integer> lotto) {
        int matchCount = 0;
        for (int num : winnerNumbers) {
            if (lotto.contains(num)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public LottoRank getLottoRank(Lotto lotto, WinningNumbers winningNumbers) {

        return LottoRank.FIRST_PLACE;
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


    public long getProfit() {
        long profit = 0;
        profit += numOfFirstPlace * LottoRank.FIRST_PLACE.getPrize();
        profit += numOfSecondPlace * LottoRank.SECOND_PLACE.getPrize();
        profit += numOfThirdPlace * LottoRank.THIRD_PLACE.getPrize();
        profit += numOfFourthPlace * LottoRank.FOURTH_PLACE.getPrize();
        profit += numOfFifthPlace * LottoRank.FIFTH_PLACE.getPrize();

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
