package lotto.views;

import lotto.Lotto;
import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Constants;

public class SystemMessage {

    public String getPurchasePrice() {
        System.out.println(Constants.PURCHASE_PRICE);
        return Console.readLine();
    }

    public String getLottoNumbers() {
        System.out.println("\n" + Constants.LOTTO_NUMBERS);
        return Console.readLine();
    }

    public String getBonusNumbers() {
        System.out.println("\n" + Constants.BONUS_NUMBER);
        return Console.readLine();
    }

    public void printPurchasedResult(Integer amount) {
        System.out.println("\n" + amount + Constants.PURCHASED_RESULT);
    }

    public void setPrintResult() {
        System.out.println(Constants.RESULT);
    }

    public void printLottoResult(Integer threeWin, Integer fourWin, Integer fiveWin, Integer bonusWin, Integer wholeWin) {
        System.out.println(Constants.THREE_MATCHED + threeWin + '개');
        System.out.println(Constants.FOUR_MATCHED + fourWin + '개');
        System.out.println(Constants.FIVE_MATCHED + fiveWin + '개');
        System.out.println(Constants.BONUS_MATCHED + bonusWin + '개');
        System.out.println(Constants.WHOLE_MATCHED + wholeWin + '개');
    }
}
