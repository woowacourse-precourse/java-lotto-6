package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private List<Integer> winningNumber = new ArrayList<>();
    private int bonusNumber;


    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningNumber(List<String> winningNumberInput) {
        for (String num : winningNumberInput) {
            this.winningNumber.add(Integer.parseInt(num));
//            Collections.sort(winningNumber);
        }
    }

    public void setBonusNumber(String bonusNumberInput) {
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }
}
