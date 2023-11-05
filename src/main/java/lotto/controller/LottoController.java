package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.service.InputMoneyService;
import lotto.service.InputWinnerNumberService;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {


    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;


    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = new Validator();
    }

    public void start() {
        Long money = inputMoney(new InputMoneyService());
        List<Integer> lottoWinNumbers = inputWinNumbers(new InputWinnerNumberService());


        /*
            금액에 따른 로또 번호 뽑기!

         */

        /*
        당첨 번호 입
         */

    }



    private Long inputMoney(InputMoneyService inputMoneyService) {
        try {
            outputView.printBeforeInputMoney();
            inputMoneyService.getRightMoneyProcess(validator, inputView.inputMoney());
            return Long.parseLong(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return inputMoney(inputMoneyService);
        }
    }

    private List<Integer> inputWinNumbers(InputWinnerNumberService inputWinnerNumberService) {
        try {
            inputWinnerNumberService.checkRightWinnerNumbers(validator,
                inputView.inputWinnerNumbers());
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return inputWinNumbers(inputWinnerNumberService);
        }
    }

}
