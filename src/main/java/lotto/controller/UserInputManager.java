package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputManager {

    public String getPurchasePriceInput() {
        return readLine();
    }

    public String getBonusNumberInput() {
        return readLine();
    }

    public String getWinningNumbersInput() {
        System.out.println("당첨 번호를 입력하세요 (6개의 숫자를 쉼표로 구분하여 입력):");
        return readLine();
    }
}