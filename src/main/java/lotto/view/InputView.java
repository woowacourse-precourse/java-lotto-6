package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InfoMessage;

public class InputView {
    public String requestPurchasePrice() {
        System.out.println(InfoMessage.REQUEST_PURCHASE_PRICE.getMessage());
        String purchasePrice = Console.readLine();
        return purchasePrice;
    }

    public String requestWinningNumbers() {
        System.out.println("\n" + InfoMessage.REQUEST_WINNING_NUMBERS.getMessage());
        String winningNumbers = Console.readLine();

        return winningNumbers;
    }

    public String requestBonusNumber() {
        System.out.println("\n" + InfoMessage.REQUEST_BONUS_NUMBER.getMessage());
        String bonusNumbers = Console.readLine();

        return bonusNumbers;
    }
}
