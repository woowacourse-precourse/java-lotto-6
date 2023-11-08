package lotto.View;

import static lotto.util.StringTo.stringToLotto;
import static lotto.util.Verify.verifyAmount;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;

public class InputView {

    public InputView(){}

    public static Integer getHowMuchLottoWillYouBuy() throws IllegalArgumentException{
        String input = Console.readLine();
        Integer value = verifyAmount(input);
        return value;
    }

    public static Lotto getWinningLottoNumbers(){
        String input = Console.readLine();
        Lotto winningLotto= stringToLotto(input);
        return winningLotto;
    }
}
