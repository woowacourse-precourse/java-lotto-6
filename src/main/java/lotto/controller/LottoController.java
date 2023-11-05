package lotto.controller;

import lotto.common.message.InputMessage;
import lotto.validator.InputValidator;
import lotto.views.InputView;
import lotto.views.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final InputValidator inputValidator = new InputValidator();
    private final OutputView outputView = new OutputView();

    public void start(){
        String inputPrice = inputView.inputPrice();
        boolean isRestart;
        try{
           isRestart = inputValidator.validateInputPrice(inputPrice);
        } catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
            return;
        }
        nextPriceCheck(isRestart, Integer.parseInt(inputPrice));
    }
    private void nextPriceCheck(boolean isRestart, int inputPrice) {
        if (isRestart) {
            System.out.println(InputMessage.INPUT_PRICE_CHECK);
            start();
            return;
        }
        //받은 금액만큼 로또를 발행하기
        outputView.outputPublishLottos(inputPrice);
    }
}
