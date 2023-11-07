package lotto.controller;

import lotto.Lotto;
import java.util.List;
import static lotto.controller.LottoController.*;
import static lotto.controller.LottoController.lottoNumbers;
import static lotto.view.OutView.outputLottoNumber;

public class GameController {
    private List<Lotto> lotto;
    private List<Integer> list;

    public GameController() {
        //구매 금액 입력
        setLotto();
        // 티켓 출력
        outputLottoTickets();
        //당첨 번호 입력
        inputWinningNumbers();
    }

    private void setLotto() {
        int amount = setPurchaseAmount();
        lotto = setLottoNumber(amount);
    }

    private void outputLottoTickets() {
        outputLottoNumber(lotto);
    }

    private void inputWinningNumbers() {
        list = lottoNumbers();
    }
}
