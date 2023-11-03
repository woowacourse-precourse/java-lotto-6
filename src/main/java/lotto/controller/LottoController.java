package lotto.controller;

import lotto.util.converter.NumericConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final NumericConverter numericConverter = new NumericConverter();
    private final InputView inputView = new InputView();
    private final OutputView  outputView = new OutputView();

    public void run(){
        int amount = getAmount();

    }

    private int getAmount(){
        String input = inputView.readAmount();
        int amount = numericConverter.convert(input)/1000;
        outputView.printAmount(amount);
        return amount;
    }


}
