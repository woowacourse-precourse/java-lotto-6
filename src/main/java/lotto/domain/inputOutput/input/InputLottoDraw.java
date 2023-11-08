package lotto.domain.inputOutput.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputOutputConstants;

public class InputLottoDraw {
    public String inputLottoDrawNumber(){
        System.out.println(InputOutputConstants.LOTTO_DRAW_NUMBER_INPUT_MESSAGE.getValue());
        return Console.readLine();
    }
    public String inputLottoDrawBonusNumber(){
        System.out.println(InputOutputConstants.LOTTO_DRAW_BONUS_NUMBER_INPUT_MESSAGE.getValue());
        return Console.readLine();
    }


}
