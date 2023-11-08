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
        for (int i = 0; i < lottoNumber.size(); i++) {
            equalNum = compareNumbers(lottoNumber.get(i), equalNum);
        }
        return equalNum;
    }

    private int compareNumbers(int lottoNumber, int equalNum) {
        for (int i = 0; i < prizeNumber.size(); i++) {
            if (prizeNumber.get(i) == lottoNumber) {
                equalNum += 1;
                return equalNum;
            }
        }
        return equalNum;
    }
}
