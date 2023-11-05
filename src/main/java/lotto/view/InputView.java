package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserMoney;
import lotto.view.parser.InputParser;

public class InputView {

    private final InputParser inputParser;

    public InputView(){
        inputParser = new InputParser();
    }

    public UserMoney getUserMoney(){
        return inputParser.parseUserMoney(readLine());
    }

    private String readLine(){
        return Console.readLine();
    }
}