package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import static lotto.constant.InputMessage.*;

public class InputView {
    public static String InputpurchaseAmount(){
        System.out.println(PURCHASE.getMessage());
        return Console.readLine();
    }

    public static String InputLottoNumbers(){
        System.out.println(WINNING.getMessage());
        return Console.readLine();
    }

    public static String InputBonusNumbers(){
        System.out.println(BONUS.getMessage());
        return Console.readLine();
    }
}
