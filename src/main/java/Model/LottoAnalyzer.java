package Model;

import java.util.ArrayList;
import java.util.List;

public class LottoAnalyzer {
    Lotto prizeLotto;
    private int bonusNumber;
    private float yield;
    public LottoAnalyzer(List<String> prizeNumbers, int bonusNumber) {
        List<Integer> prizeNumber = prizeNumber(prizeNumbers);
        prizeLotto = new Lotto(prizeNumber);
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
}
