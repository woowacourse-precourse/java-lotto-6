package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Constants;

public class SystemMessage {

    public String getPurchasePrice() {
        System.out.println(Constants.PURCHASE_PRICE);
        return Console.readLine();
    }

    public String getLottoNumbers() {
        System.out.println(Constants.LOTTO_NUMBERS);
        return Console.readLine();
    }

    public String getBonusNumbers() {
        System.out.println(Constants.BONUS_NUMBER);
        return Console.readLine();
    }
}
