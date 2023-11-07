package lotto;

import java.util.*;

public class WinCalculator {

    static final int MAX_MATCH_COUNT = 6;

    public Map<Integer, Integer> winStatics(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber) {
        //Map<당첨등수, 당첨갯수>
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (Lotto lotto : lottoList) {
        }
        return new HashMap<>();
    }

    public int rankCounter(Lotto lotto, List<Integer> winNumbers, int bonusNumber) {
        int counter = 0;
        for (int lottoNumber : lotto.getNumbers()) {
            if (winNumbers.contains(lottoNumber)) {
                counter++;
            }
        }
        if (counter == 6) {
            if (isContainBonusNumber(lotto, bonusNumber)) {
                return 2;
            }
        }
        return MAX_MATCH_COUNT - counter + 1;
    }

    public boolean isContainBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public int totalWinMoney() {
        return 0;
    }

    public void printWinStatics() {

    }

}
