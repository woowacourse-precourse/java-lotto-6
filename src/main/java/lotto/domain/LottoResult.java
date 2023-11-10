package lotto.domain;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.List;

import static lotto.util.Util.*;
import static lotto.util.Util.inputWinningNumbers;
import static lotto.validation.InputValidation.*;

public class LottoResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResult() {
        List<Integer> wn = inputWinningNumbers();
        winningNumbers = validateWinningNumbers(wn);
        bonusNumber= inputBonusNumber();
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }
}
