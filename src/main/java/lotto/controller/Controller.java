package lotto.controller;

import lotto.constants.Constants;
import lotto.utils.Utils;
import lotto.validation.InputValidation;
import lotto.view.InputView;

public class Controller {
    InputView inputView = new InputView();
    InputValidation inputValidation = new InputValidation();
    Utils utils = new Utils();

    public void playLotto(){
        purchaseLotto();
    }
    public int purchaseLotto(){
        String lottoPrice = inputView.showInputMention();
        inputValidation.checkInteger(lottoPrice);
        Integer lottoPriceInNumber = utils.makeStringToInteger(lottoPrice);
        inputValidation.checkRemainder(lottoPriceInNumber);
        utils.figureOutQuotient(lottoPriceInNumber, Constants.LOTTO_PRICE);

    }

}
