package lotto.controller;

import lotto.domain.CreateLottoNumbers;
import lotto.view.InputView;

public class LottoController {

    public void startLotto() {
        InputView inputView = new InputView();
        int amount = inputView.lottoAmount();
        CreateLottoNumbers createLottoNumbers = new CreateLottoNumbers();
        createLottoNumbers.createLottoMain(amount);
    }
}
