package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputOutputConstants;

public class InputManager {
    public String inputLottoDrawNumber(){
        System.out.print(InputOutputConstants.LOTTO_DRAW_NUMBER_INPUT_MESSAGE.getValue());
        return Console.readLine();
    }
    public String inputLottoDrawBonusNumber(){
        System.out.print(InputOutputConstants.LOTTO_DRAW_BONUS_NUMBER_INPUT_MESSAGE.getValue());
        return Console.readLine();
    }


}
