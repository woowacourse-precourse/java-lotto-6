package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {
    public static int money;
    public static List<Integer> winningNumbers;
    public static int bonusNumber;

    public InputController() {
        money = 0;
        winningNumbers = new ArrayList<>();
        bonusNumber = 0;
    }

    public static void inputMoney() {
        String stringMoney = readLine();
        money = Integer.parseInt(stringMoney);
    }
    public static void inputWinningNumbers() {
        winningNumbers = new ArrayList<>();
        String[] numberStrings = readLine().split(",", -1);
        // [예외처리] 입력한 당첨 번호 중에 공백이 있는 경우
        // [예외처리] 중복된 숫자를 입력한 경우
        // [예외처리] 범위에서 벗어나는 숫자를 입력한 경우
        for (String numberString : numberStrings) {
            winningNumbers.add(Integer.parseInt(numberString));
        }
    }
    public static void inputBonusNumber() {
        String userInputBonusNumbers = readLine();
        bonusNumber = Integer.parseInt(userInputBonusNumbers);
    }
}
