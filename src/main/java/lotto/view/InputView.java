package lotto.view;


import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumber;
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

    public Lotto enterWinningNumbers() {
        while (true) {
            try {
                System.out.println(InputMessage.ENTER_WINNING_NUMBER_PRINT.getMessage());
                String readWinningNumber = readLine();
                LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(readWinningNumber);
                return lottoWinningNumber.getReadWinningNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
