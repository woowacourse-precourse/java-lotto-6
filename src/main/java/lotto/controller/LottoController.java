package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.LottoView;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final LottoView lottoView;

    public LottoController(LottoMachine lottoMachine, LottoView lottoView) {
        this.lottoMachine = lottoMachine;
        this.lottoView = lottoView;
    }

    public void runMachine() {
        // TODO : lottoView 구현 반영.
        Lotto lotto = lottoMachine.generateLotto();
    }

    private void validatePurchaseAmount(int money) {
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 정수여야 합니다.");
        }
    }


}
