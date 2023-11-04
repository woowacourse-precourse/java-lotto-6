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
        LottoMoney lottoMoney = InputView.showMoney();  // 로또 금액 입력
        lottoMoney.setNumbers();  // 로또 번호 발행
        InputView.viewNumber(lottoMoney);   // 로또 번호 출력
        // 로또 당첨 번호 입력
    }
}
