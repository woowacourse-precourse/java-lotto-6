package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.Constants.*;

public class InputView {
    public String inputCost(){
        System.out.println(START_COST_MESSAGE);
        return Console.readLine();
    }
    public String inputLottoNum(){
        System.out.println(START_NUM_MESSAGE);
        return Console.readLine();
    }
    public String inputLottoBonusNum(){
        System.out.println();
        System.out.println(START_BONUS_MESSAGE);
        return Console.readLine();
    }
}
