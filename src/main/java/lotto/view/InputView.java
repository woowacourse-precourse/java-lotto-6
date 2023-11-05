package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int money;
    public static List<Integer> winningNumbers;
    public static int bonusNumber;

    public static void inputMoney() {
        OutputView.printInputMoneyMsg();

        String stringMoney = readLine();
        money = Integer.parseInt(stringMoney);
    }
    public static void inputWinningNumbers() {
        OutputView.printInputWinningNumbersMsg();

        String[] numberStrings = readLine().split(",", -1);
        // [예외처리] 입력한 당첨 번호 중에 공백이 있는 경우
        // [예외처리] 중복된 숫자를 입력한 경우
        // [예외처리] 범위에서 벗어나는 숫자를 입력한 경우
        for (String numberString : numberStrings) {
            winningNumbers.add(Integer.parseInt(numberString));
        }
    }
    public static void inputBonusNumber() {
        OutputView.printInputBonusNumberMsg();

        String userInputBonusNumbers = readLine();
        bonusNumber = Integer.parseInt(userInputBonusNumbers);
    }
}
