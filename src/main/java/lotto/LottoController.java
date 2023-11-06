package lotto;


import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.Prize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
        Lotto lotto = InputView.insertLottoNum();   // 로또 당첨 번호 입력
        InputView.insertBonusNum(lotto);    // 로또 보너스 번호 입력
        OutputView.winningLotto(lotto.getNumbers(), lottoMoney.getNumbers());  // 로또 당첨 여부 확인
        OutputView.viewResult();    // 결과 출력
    }
}
