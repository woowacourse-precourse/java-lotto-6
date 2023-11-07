package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputManager {

    public String getPurchasePriceInput() {
        return readLine();
    }

    public String getBonusNumberInput() {
        return readLine();
    }

    // 사용자로부터 당첨 번호를 입력받는 메소드
    public String getWinningNumbersInput() {
        return readLine();
    }

}