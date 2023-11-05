package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getLine(){
        return Console.readLine();
    }

    public void close(){
        Console.close();
    }
}
