package lotto.controller;

import lotto.utils.Converter;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private static final String DELIMITER_FOR_INPUT = ",";
    private final InputView inputView;

    public LottoController() {
        this.inputView = new InputView();
    }

    public void run() {
        Integer budget = Converter.stringToInt(inputView.ask(inputView.budget()));
        List<Integer> mainNumbers = Converter.stringToIntList(inputView.ask(inputView.mainNumbers()), DELIMITER_FOR_INPUT);
        Integer bonusNumber = Converter.stringToInt(inputView.ask(inputView.bonusNumber()));


    }
}
