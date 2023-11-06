package lotto.contoller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumber;
import lotto.view.LottoView;

public class LottoController {

    public final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    private PurchaseAmount receivePurchaseAmount() {
        while (true) {
            try {
                lottoView.printInputPurchaseAmount();
                String answer = Console.readLine();
                return new PurchaseAmount(answer);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumber receiveWinningNumber() {
        while (true) {
            try {
                lottoView.printInputWinningNumber();
                String answer = Console.readLine();
                return new WinningNumber(answer);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumber receiveBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                lottoView.printInputBonusNumber();
                String answer = Console.readLine();
                winningNumber.setBonusNumber(answer);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
