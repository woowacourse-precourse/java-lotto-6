package lotto.view;


import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.InputMessage.*;

import lotto.domain.Lotto;
import lotto.domain.LottoBonusNumber;
import lotto.domain.LottoWinningNumber;
import lotto.domain.ReadPurchaseAmount;

public class InputView {

    public String enterLottoPurchaseAmount() {
        while (true) {
            try {
                System.out.println(ENTER_PURCHASE_AMOUNT_PRINT.getMessage());
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
                System.out.println(ENTER_WINNING_NUMBER_PRINT.getMessage());
                String readWinningNumber = readLine();
                LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(readWinningNumber);
                return lottoWinningNumber.getReadWinningNumber();
            } catch (IllegalArgumentException e) {
                if (!"".equals(e.getMessage()) && e.getMessage() != null) {
                    System.out.println(e.getMessage());
                }
            }

        }

    }

    public Integer enterBonusNumber(Lotto winningLottoNumber) {
        while (true) {
            try {
                System.out.println(ENTER_BONUS_NUMBER_PRINT.getMessage());
                String readBonusNumber = readLine();
                LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(readBonusNumber, winningLottoNumber);
                return lottoBonusNumber.getLottoBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
