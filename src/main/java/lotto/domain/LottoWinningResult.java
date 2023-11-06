package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static constant.MessageList.TOTAL_LOTTO_NUMBER_IN_LIST;

public class LottoWinningResult {
    private int[] prizeCount;
    private int correctCount;
    private List<Integer> numberFromPlayer;
    private List<Integer> lottoNumber;
    private int bonusNumber;

    public LottoWinningResult(List<Integer> numberFromPlayer, int bonusNumber, List<Integer> lottoNumber) {
        prizeCount = new int[5];
        this.numberFromPlayer = sortList(numberFromPlayer);
        this.lottoNumber = sortList(lottoNumber);
        this.bonusNumber = bonusNumber;
    }

    public int[] getWinningResult() {
        checkFirstPlace();
        checkOtherPlace();
        return prizeCount;
    }

    private List<Integer> sortList(List<Integer> number) {
        return number.stream().sorted().collect(Collectors.toList());
    }

    private void checkFirstPlace() {
        if (lottoNumber.equals(numberFromPlayer)) {
            prizeCount[0]++;
        }
    }

    private void checkOtherPlace() {
        for (int i = 0; i < TOTAL_LOTTO_NUMBER_IN_LIST; i++) {
            if (lottoNumber.get(i).equals(numberFromPlayer.get(i))) {
                correctCount++;
            }
        }
        if (correctCount == 5 && isSecondPrize()) {
            prizeCount[1]++;
        }
        if (correctCount == 5 && !isSecondPrize()) {
            prizeCount[2]++;
        }
        if (correctCount == 4) {
            prizeCount[3]++;
        }
        if (correctCount == 3) {
            prizeCount[4]++;
        }
    }

    private boolean isSecondPrize() {
        for (int number : lottoNumber) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}
