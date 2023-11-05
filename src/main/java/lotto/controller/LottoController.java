package lotto.controller;

import lotto.validator.InputValidator;
import lotto.views.InputView;
import lotto.views.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final InputValidator inputValidator = new InputValidator();
    private final OutputView outputView = new OutputView();

    public void start(){
        String price = inputView.inputPrice();
        boolean isRestart;
        try{
           isRestart = inputValidator.validateInputPrice(price);
        } catch (IllegalArgumentException error){
            outputView.outputMessage(error.getMessage());
        }


    }



}
