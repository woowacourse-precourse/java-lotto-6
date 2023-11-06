package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.util.Parser.stringToInt;
import static lotto.util.Parser.stringToList;

public class WinningNumbers {
    Lotto lotto;
    int bonusNumber;

    public WinningNumbers(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }



}
