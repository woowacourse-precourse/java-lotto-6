package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constants.NumberOfLottoPurchaseConstants.PURCHASEVIEW;

public class NumberOfLottoPurchaseView {
    public String lottoPurchaseInterface() {
        System.out.println(PURCHASEVIEW);
        return readLine();
    }
}
