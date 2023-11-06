package lotto.Domain;

import java.util.List;
import lotto.Constants.ExceptionMessage;

public class BonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int bonusNumber;

    public  BonusNumber(int bonusNumber, List<Integer> winningNumbers){
        this.bonusNumber = bonusNumber;
    }
}
