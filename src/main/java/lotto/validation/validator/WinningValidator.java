package lotto.validation.validator;

import lotto.property.ErrorProperty;

import static lotto.property.LottoProperty.*;

public class WinningValidator extends RootValidator{

    public static void winnerIsCorrectRange(String winningNumber){
        int winningInteger = Integer.parseInt(winningNumber);
        if (winningInteger < LOTTO_START || winningInteger > LOTTO_END){
            throw new IllegalArgumentException(ErrorProperty.WINNING_IS_NOT_CORRECTLY_RANGE.toString());
        }
    }
}
