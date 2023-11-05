package lotto.view;


import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.ReadPurchaseAmount;

public class InputView {

    public String enterLottoPurchaseAmount() {
        while (true) {
            try {
                System.out.println(InputMessage.ENTER_PURCHASE_AMOUNT_PRINT.getMessage());
                String readAmount = readLine();
                ReadPurchaseAmount readPurchaseAmount = new ReadPurchaseAmount(readAmount);
                return readPurchaseAmount.getReadPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String enterWinningNumbers() {
        while (true) {
            System.out.println(InputMessage.ENTER_WINNING_NUMBER_PRINT.getMessage());
            String readWinningNumber = readLine();

            return readWinningNumber;
        }

    }
}
