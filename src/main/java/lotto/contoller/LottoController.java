package lotto.contoller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoList;
import lotto.model.PurchaseAmount;
import lotto.model.Result;
import lotto.model.WinningNumber;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void startLotto() {
        PurchaseAmount purchaseAmount = receivePurchaseAmount();

        LottoList lottoList = new LottoList(purchaseAmount);
        lottoView.printLottoNumber(lottoList);

        WinningNumber winningNumber = receiveWinningNumber();
        receiveBonusNumber(winningNumber);

        Result result = lottoList.calculateWinningStatistics(winningNumber);
        lottoView.printResult(result, purchaseAmount);
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

    private void receiveBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                lottoView.printInputBonusNumber();
                String answer = Console.readLine();
                winningNumber.setBonusNumber(answer);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
