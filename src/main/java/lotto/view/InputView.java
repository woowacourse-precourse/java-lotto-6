package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int inputMoney() {
        OutputView.printInputMoneyMsg();

        String stringMoney = readLine();
        int money = Integer.parseInt(stringMoney);

        return money;
    }
    public static List<String> inputWinningNumbers() {
        OutputView.printInputWinningNumbersMsg();

        String userInputWinningNumbers = readLine();
        List<String> winningNumbers = new ArrayList<>(Arrays.asList(userInputWinningNumbers.split(",", -1)));

        // [예외처리] 입력한 당첨 번호 중에 공백이 있는 경우
        // [예외처리] 중복된 숫자를 입력한 경우
        // [예외처리] 범위에서 벗어나는 숫자를 입력한 경우

        return winningNumbers;
    }
    public static int inputBonusNumber() {
        OutputView.printInputBonusNumberMsg();

        String userInputBonusNumbers = readLine();
        int bonusNumber = Integer.parseInt(userInputBonusNumbers);

        return bonusNumber;
    }
}
