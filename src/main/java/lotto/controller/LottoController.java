package lotto.controller;

import lotto.common.message.ExceptionMessage;
import lotto.domain.Lotto;
import lotto.domain.WinnerNumbers;
import lotto.validator.LottoPriceValidator;
import lotto.view.InputView;
import lotto.view.OutputView;


import java.util.List;

import static lotto.domain.WinnerNumbers.bonusNumbersValidateCheck;
import static lotto.domain.WinnerNumbers.winnerNumbersValidateCheck;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoPriceValidator inputLottoPriceValidator = new LottoPriceValidator();

    public void start(){
        purchase();
        List<String> winnerNumbers = winnerNumbersValidateCheck(inputView.inputWinnerNumbers());
        String bonusNumber = bonusNumbersValidateCheck(inputView.inputBonusNumber());
        while(!WinnerNumbers.isBonusNumberDuplicateCheck(bonusNumber, winnerNumbers)) {
            System.out.println(ExceptionMessage.BONUS_NUMBER_CHECK);
            bonusNumber = inputView.inputBonusNumber();
        }
    }

    public void purchase(){
        String price = inputView.inputPrice();
        boolean isRestart;
        try{
            isRestart = inputLottoPriceValidator.validateInputPrice(price);
        } catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
            start();
            return;
        }
        priceCorrectCheck(isRestart, Integer.parseInt(price));
    }

    public void priceCorrectCheck(boolean isRestart, int inputPrice) {
        if (isRestart) {
            System.out.println(ExceptionMessage.INPUT_PRICE_CHECK);
            start();
            return;
        }
        int lottoCount = outputView.outputPurchaseLotto(inputPrice);
        Lotto.randomNumberLotto(lottoCount);
    }

}
