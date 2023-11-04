package lotto.validation.validator;

import lotto.property.ErrorProperty;

import static lotto.property.LottoProperty.*;

public class WinningValidator extends RootValidator{

    public static void winnerIsCorrectRange(Integer winnerNumber){
        if (winnerNumber < LOTTO_START || winnerNumber > LOTTO_END){
            throw new IllegalArgumentException(ErrorProperty.WINNING_IS_NOT_CORRECTLY_RANGE.toString());
        }
    }
}
