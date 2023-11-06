package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.LottoView;

public class LottoController {

    private LottoView lottoView = new LottoView();

    public void runLotto(){
        String lottoPurchase = lottoView.inputLottoPurchase();
    }
}
