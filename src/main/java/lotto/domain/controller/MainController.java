package lotto.domain.controller;

import lotto.domain.view.InputView;
import lotto.domain.service.LottoCalculator;
public class MainController {
    public void purchaseLotto(){
        InputView inputView = new InputView();
        int userPurchasePrice = inputView.inputLottoPrice();
        LottoCalculator lottoCalculator = new LottoCalculator();
        int lottoCount = lottoCalculator.calculateNumberOfLotto(userPurchasePrice);


    }

}
