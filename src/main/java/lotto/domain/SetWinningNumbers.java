package lotto.domain;

import lotto.service.NumberConverter;
import lotto.view.InputView;

import java.util.List;

public class SetWinningNumbers {
    NumberConverter numberConverter = new NumberConverter();
    InputView inputView = new InputView();

    public List<Integer> setWinningNumbers(){
        String inputNum = inputWinningNumbers();
        return numberConverter.convertNumberList(inputNum);
    }


    private String inputWinningNumbers(){
        return inputView.setWinNumber();
    }
}
