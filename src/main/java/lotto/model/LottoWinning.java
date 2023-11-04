package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class LottoWinning {
    private List<Integer> winningNumber;
    private int bonusNumber;

    public LottoWinning(String _winningNumber) {
        winningNumber = new ArrayList<Integer>();
        for (String number : _winningNumber.split(",")) {
            winningNumber.add(parseInt(number));
        }
    }

    public void initBonusNumber(String number) {
        bonusNumber = parseInt(number);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
