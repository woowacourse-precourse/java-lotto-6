package lotto.View;

import static lotto.util.Verify.verifyAmount;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView(){}

    public static Integer getHowMuchLottoWillYouBuy() throws IllegalArgumentException{
        String money = Console.readLine();
        Integer value = verifyAmount(money);
        return value;
    }
}
