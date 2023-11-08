package Model;

import java.util.ArrayList;
import java.util.List;

public class LottoAnalyzer {
    private List<Integer> prizeNumber;
    private int bonusNumber;
    private float yield;
    private List<Integer> numberOfWins;

    public LottoAnalyzer(List<String> prizeNumbers, int bonusNumber) {
        this.prizeNumber = prizeNumber(prizeNumbers);
        this.bonusNumber = bonusNumber;
        this.yield = 0;
        numberOfWins = List.of(0,0,0,0,0);
    }

    private List<Integer> prizeNumber(List<String> prizeNumbers) {
        List<Integer> prizeNumber = new ArrayList<>();
        for (String number : prizeNumbers) {
            int num = Integer.parseInt(number);
            prizeNumber.add(num);
        }
        return prizeNumber;
    }

    public void compareLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int equalNum = compare(lotto.getNumbers());
            saveCompare(equalNum, lotto.getNumbers());
        }
    }

    public int compare(List<Integer> lottoNumber) {
        int equalNum = 0;
        for (Integer integer : lottoNumber) {
            equalNum = compareNumbers(integer, equalNum);
        }
        return equalNum;
    }

    private int compareNumbers(int lottoNumber, int equalNum) {
        for (Integer integer : prizeNumber) {
            if (integer == lottoNumber) {
                equalNum += 1;
                return equalNum;
            }
        }
        return equalNum;
    }

    private void saveCompare(int equalNum, List<Integer> lottoNumber) {
        if (equalNum == 3) {
            addNumberOfWins(0);
        }
        if (equalNum == 4) {
            addNumberOfWins(1);
        }
        if (equalNum == 5) {
            if (compareBonusNumber(lottoNumber)) {
                addNumberOfWins(2);
            }
            if (!compareBonusNumber(lottoNumber)) {
                addNumberOfWins(3);
            }
        }
        if (equalNum == 6) {
            addNumberOfWins(4);
        }
    }

    private void addNumberOfWins(int i) {
        int num = numberOfWins.get(i) + 1;
        numberOfWins.set(i, num);
    }

    private boolean compareBonusNumber(List<Integer> lottoNumber) {
        for (Integer num : lottoNumber) {
            if (bonusNumber == num) {
                return false;
            }
        }
        return true;
    }
}
