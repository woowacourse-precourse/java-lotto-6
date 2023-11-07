package lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.GameInput;
import lotto.GameOutput;

public class GameController {
    private GameController(){

        GameOutput.printUserCashInterface();
        GameInput.getUserCash();
        GameOutput.printUserHopeLottoNumbersInterface();
        GameInput.getUserHopeLottoNumbers();
        GameOutput.getUserHopeBonusNumbersInterface();
        GameInput.getUserHopeBonusNumbers();
        Console.close();
    }
}
