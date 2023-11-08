package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.CustomIllegalArgumentException;
import lotto.view.message.ViewMessage;

public class LottoView {
    public void outputException(CustomIllegalArgumentException exception) {
        System.out.println();
        System.out.println(exception.getMessage());
    }

    public String inputPurchaseAmount() {
        System.out.println(ViewMessage.ENTER_PURCHASE_AMOUNT
                .getMessage());
        return Console.readLine();
    }

    public String inputWinLottoNumbers() {
        System.out.println();
        System.out.println(ViewMessage.WINNING_NUMBER_INPUT
                .getMessage());

        return Console.readLine();
    }

    public String inputWinBonusNumbers() {
        System.out.println();
        System.out.println(ViewMessage.BONUS_NUMBER_INPUT
                .getMessage());

        return Console.readLine();
    }

    public void displayPurchasedLottoCount(int purchaseCount) {
        System.out.println();
        System.out.println(ViewMessage.NUMBER_OF_TICKETS_PURCHASED
                .getMessage(purchaseCount));
    }

    public void displayPurchasedLottoInfo(String lottoInfo) {
        System.out.println(lottoInfo);
    }

    public void displayLottoResult(String lottoResult) {
        System.out.println();
        System.out.println(ViewMessage.WINNING_STATISTICS_HEADER
                .getMessage());
        System.out.println(ViewMessage.WINNING_STATISTICS_SEPARATOR
                .getMessage());
        System.out.println(lottoResult);
    }

    public void displayProfitability(Float profitability) {
        System.out.println(ViewMessage.TOTAL_PROFIT_PERCENTAGE
                .getMessage(profitability));
    }
}
