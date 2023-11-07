package lotto.controller;

import lotto.Lotto;
import java.util.List;
import static lotto.controller.LottoController.*;
import static lotto.view.OutView.outputLottoNumber;

public class GameController {
    private List<Lotto> lotto;

    public GameController() {
        //구매 금액 입력
        setLotto();
        // 티켓 출력
        outputLottoTickets();
    }

    private void setLotto() {
        int amount = setPurchaseAmount();
        lotto = setLottoNumber(amount);
    }

    private void outputLottoTickets() {
        outputLottoNumber(lotto);
    }
}
