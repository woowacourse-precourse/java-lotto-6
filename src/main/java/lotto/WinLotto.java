package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinLotto(List<String> winNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String winNumber : winNumbers) {
            numbers.add(Integer.parseInt(winNumber));
        }

        lotto = new Lotto(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }
}
