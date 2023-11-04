package lotto;


import lotto.domain.LottoMoney;
import lotto.view.InputView;

public class LottoController {
    static int count;
    public LottoController() {
    }

    public static LottoController begin() {
        return new LottoController();
    }

    public void play() {
        LottoMoney lottoMoney = InputView.showMoney();  // 로또 금액 입력
        lottoMoney.setNumbers();  // 로또 번호 발행
    }
}
