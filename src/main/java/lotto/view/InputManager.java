package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    public String readData() {
        return readLine();
    }
    public int getPurchaseAmount(String data) {
        //예외처리
        return Integer.parseInt(data);
    }
}
