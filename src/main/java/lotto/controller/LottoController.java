package lotto.controller;

import lotto.domain.*;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController {

    public void start(){
        LottoAmount lottoAmount = inputAmount();
        printLottos(lottoAmount);
    }
    private LottoAmount inputAmount(){
        try {
            return new LottoAmount(inputPrice());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }
}
