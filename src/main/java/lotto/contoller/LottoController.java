package lotto.contoller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.PurchaseAmount;
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


}
