package lotto;

import camp.nextstep.edu.missionutils.Console;
import static lotto.InputMessage.*;

public class InputView {
    public String InputpurchaseAmount(){
        System.out.println(PURCHASE.getMessage());
        return Console.readLine();
    }

    public String InputLottoNumbers(){
        System.out.println(WINNING.getMessage());
        return Console.readLine();
    }

    public String InputBonusNumbers(){
        System.out.println(BONUS.getMessage());
        return Console.readLine();
    }
}
