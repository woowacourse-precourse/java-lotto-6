package lotto.controller;

import lotto.model.*;
import lotto.validation.ValidationUtils;
import lotto.view.LottoView;

public class LottoController {
    private boolean isValid;
    private String userInput;
    private LottoView lottoView;
    private ValidationUtils validationUtils;
    private LottoNumberCreator lottoNumberCreator;

    public LottoController() {
        lottoView = new LottoView();
        validationUtils = new ValidationUtils();
        lottoNumberCreator = new LottoNumberCreator();
    }

    public void startLotto() {
        UserAmount userAmount = createUserAmount();
        Lottos lottos = createLottos(userAmount);
        WinningNumber winningNumber = createWinningNumber();

        addBonusNumberToWinningNumber(winningNumber);

        LottoResult lottoResult = createResult(userAmount, lottos, winningNumber);
        lottoView.printWinningStatistics(lottoResult);
    }

    private UserAmount createUserAmount() {
        userInput = lottoView.inputUserAmount();
        isValid = validationUtils.validateUserAmount(userInput);

        while(!isValid) {
            userInput = lottoView.inputUserAmount();
            isValid = validationUtils.validateUserAmount(userInput);
        }

        return new UserAmount(userInput);
    }

    private Lottos createLottos(UserAmount userAmount) {
        Lottos lottos = lottoNumberCreator.createLottoNumbers(userAmount.getNumberOfLotto());
        lottoView.printLottoNumbers(lottos);
        return lottos;
    }

    private WinningNumber createWinningNumber() {
        String userInput;
        boolean isValid;
        userInput = lottoView.inputWinningNumber();
        isValid = validationUtils.validateWinningNumber(userInput);

        while(!isValid) {
            userInput = lottoView.inputWinningNumber();
            isValid = validationUtils.validateWinningNumber(userInput);
        }

        return new WinningNumber(lottoNumberCreator.stringToList(userInput));
    }

    private void addBonusNumberToWinningNumber(WinningNumber winningNumber) {
        String bonusNumber = lottoView.inputBonusNumber();
        isValid = validationUtils.validateBonusNumber(winningNumber, bonusNumber);

        while(!isValid) {
            bonusNumber = lottoView.inputBonusNumber();
            isValid = validationUtils.validateBonusNumber(winningNumber, bonusNumber);
        }

        winningNumber.addBonusNumber(bonusNumber);
    }

    private LottoResult createResult(UserAmount userAmount, Lottos lottos, WinningNumber winningNumber) {
        return new LottoResult(lottos, winningNumber, userAmount);
    }


}
