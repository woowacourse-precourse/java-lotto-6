package lotto;


import lotto.domain.LottoMoney;
import lotto.view.InputView;

public class LottoController {
    public LottoController() {
    }

    public static LottoController begin() {
        return new LottoController();
    }

    public void play() {
        // 로또 금액 입력
        LottoMoney lottoMoney = InputView.showMoney();
    }
}
