package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utility.enums.Messages.*;

public class InputView {
    public void readUserLottoPurchaseAmount(){
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        readLine();
    }
}
