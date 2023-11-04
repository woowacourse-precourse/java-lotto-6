package lotto.validation.validator;

import static lotto.property.ErrorProperty.*;
import static lotto.property.LottoProperty.*;

public class WinningValidator extends RootValidator{

    public static void winningOrBonusIsCorrectRange(String winningNumber){
        int winningInteger = Integer.parseInt(winningNumber);
        if (winningInteger < LOTTO_START || winningInteger > LOTTO_END){
            throw new IllegalArgumentException(WINNING_IS_NOT_CORRECTLY_RANGE.toString());
        }
    }
    public static void winningCountIsOverOrUnder(String winningNumbers){
        if(winningNumbers.split(DELIMITER).length!=WINNING_SIZE){
            throw new IllegalArgumentException(WINNING_COUNT_IS_OVER_OR_UNDER.toString());
        }
    }
}
