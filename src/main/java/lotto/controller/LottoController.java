package lotto.controller;

import lotto.util.converter.NumericConverter;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();

    public void run(){
        int amount = getAmount();

    }

    private int getAmount(){
        String amount = inputView.readAmount();
        return new NumericConverter().convert(amount);
    }


}
