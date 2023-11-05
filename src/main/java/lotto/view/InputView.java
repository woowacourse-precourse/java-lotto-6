package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.parser.InputParser;

public class InputView {

    private final InputParser inputParser;

    public InputView(){
        inputParser = new InputParser();
    }

    public Long getMoneyToBuyLottoFromUser(){
        return inputParser.parseMoneyToBuyLottoToNumeric(readLine());
    }

    private String readLine(){
        return Console.readLine();
    }
}