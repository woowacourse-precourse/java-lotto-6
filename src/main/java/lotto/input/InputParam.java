package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputParam {
    public int inputMoney(){
        int i = Integer.parseInt(readLine());
        return i/1000;
    }
}
