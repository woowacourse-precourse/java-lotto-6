package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PrizeLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    NumberValidator numberValidator = new NumberValidator();
    Lotto lotto;
    PrizeLotto prizeLotto;

    public void proceedLotto(){
        prizeLotto = createPrizeNum();
        System.out.println("당첨 번호 ="+prizeLotto.getPrizeNumbers());
        System.out.println("보너스 번호="+ prizeLotto.getBonusNum());
    }
    public PrizeLotto createPrizeNum(){
        return new PrizeLotto(numberValidator.prizeLottoNumValidator(inputView.enterPrizeLottoNum()), Integer.parseInt(inputView.enterBonusNum()));
    }
}
