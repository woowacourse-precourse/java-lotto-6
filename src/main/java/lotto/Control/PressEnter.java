package lotto.Control;

import camp.nextstep.edu.missionutils.Console;

public class PressEnter {
    private String buff;

    public void plzPressEnter(){
        buff = Console.readLine();
    }

    public String getInput(){
        return buff;
    }
}
