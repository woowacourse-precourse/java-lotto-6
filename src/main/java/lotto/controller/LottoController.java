package lotto.controller;

import lotto.model.*;
import lotto.validation.ValidationUtils;
import lotto.view.LottoView;

public class LottoController {
    private LottoView lottoView;
    private ValidationUtils validationUtils;
    private LottoNumberCreator lottoNumberCreator;

    public LottoController() {
        lottoView = new LottoView();
        validationUtils = new ValidationUtils();
        lottoNumberCreator = new LottoNumberCreator();
    }

    public void startLotto() {
        String userInput = lottoView.inputUserAmount();
        boolean isValid = validationUtils.validateUserAmount(userInput);

        while(!isValid) {
            userInput = lottoView.inputUserAmount();
            isValid = validationUtils.validateUserAmount(userInput);
        }

        UserAmount userAmount = new UserAmount(userInput);




        Lottos lottos = lottoNumberCreator.createLottoNumbers(userAmount.getNumberOfLotto());
        lottoView.printLottoNumbers(lottos);




        userInput = lottoView.inputWinningNumber();
        isValid = validationUtils.validateWinningNumber(userInput);

        while(!isValid) {
            userInput = lottoView.inputWinningNumber();
            isValid = validationUtils.validateWinningNumber(userInput);
        }

        WinningNumber winningNumber = new WinningNumber(lottoNumberCreator.stringToList(userInput));




        String bonusNumber = lottoView.inputBonusNumber();
        isValid = validationUtils.validateBonusNumber(winningNumber, bonusNumber);

        while(!isValid) {
            bonusNumber = lottoView.inputBonusNumber();
            isValid = validationUtils.validateBonusNumber(winningNumber, bonusNumber);
        }

        winningNumber.addBonusNumber(bonusNumber);




        LottoResult lottoResult = new LottoResult(lottos, winningNumber, userAmount);
        lottoView.printWinningStatistics(lottoResult);
    }
}
