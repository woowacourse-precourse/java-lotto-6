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
        lottoView.printInputPurchaseAmount();
        String answer = Console.readLine();
        return new PurchaseAmount(answer);
    }

    private WinningNumber receiveWinningNumber() {
        lottoView.printInputWinningNumber();
        String answer = Console.readLine();
        return new WinningNumber(answer);
    }

    private WinningNumber receiveBonusNumber(WinningNumber winningNumber) {
        lottoView.printInputBonusNumber();
        String answer = Console.readLine();
        winningNumber.setBonusNumber(answer);
        return winningNumber;
    }

}
