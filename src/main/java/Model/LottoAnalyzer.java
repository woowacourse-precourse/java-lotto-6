package Model;

import java.util.ArrayList;
import java.util.List;

public class LottoAnalyzer {
    private List<Integer> prizeNumber;
    private int bonusNumber;
    private float yield;
    public LottoAnalyzer(List<String> prizeNumbers, int bonusNumber) {
        this.prizeNumber = prizeNumber(prizeNumbers);
        this.bonusNumber = bonusNumber;
        this.yield = 0;
    }

    private List<Integer> prizeNumber(List<String> prizeNumbers) {
        List<Integer> prizeNumber = new ArrayList<>();
        for (String number : prizeNumbers) {
            int num = Integer.parseInt(number);
            prizeNumber.add(num);
        }
        return prizeNumber;
    }

    public List<Integer> getPrizeNumber() {
        return prizeNumber;
    }
    public int getBonusNumber() {
        return bonusNumber;
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
}
