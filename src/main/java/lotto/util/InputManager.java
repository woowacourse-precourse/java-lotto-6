package lotto.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputManager {

    public static int getInputMoney() {
        PrintManager.printInputMoney();
        String line = Console.readLine();
        int money = 0;
        try {
            money = Integer.parseInt(line);
            if (money % 1000 != 0 || money < 0) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.ILLEGAL_ARGUMENTS_MONEY.getMessage());
            getInputMoney();
        }
        return money;
    }

    public static List<Integer> getInputWinNumbers() {
        PrintManager.printInputWinNumbers();
        //TODO 로또 당첨 번호 입력 받기
        return null;
    }

    public static int getInputBonusNumber() {
        PrintManager.printBonusNumberInput();
        //TODO 로또 보너스 번호 입력 받기
        return 0;
    }
}
