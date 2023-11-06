package lotto.controller;

import jdk.jshell.spi.SPIResolutionException;
import lotto.domain.*;
import lotto.view.InputView;

import static lotto.validate.ValidateMessage.*;

public class LottoController {

    public void start(){
        System.out.println(inputAmount().getAmount());

    }
    private LottoAmount inputAmount(){
        try {
        LottoAmount lottoAmount = new LottoAmount(InputView.inputPrice());
         return lottoAmount;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }
}
