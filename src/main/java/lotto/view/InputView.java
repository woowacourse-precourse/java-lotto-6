package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ConsoleMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private InputView(){}

    public int inputMoney() {
        System.out.println(ConsoleMessage.INPUT_MONEY.getMessage());

        int purchaseMoney = Integer.parseInt(Console.readLine());

        return purchaseMoney;
    }

    public List<Integer> inputNumbers() {
        System.out.println(ConsoleMessage.INPUT_LOTTO_NUMBER.getMessage());
        String inputWinningNumbers = Console.readLine();
        String[] numberStrings = inputWinningNumbers.split(",");

        List<Integer> inputNumberList = new ArrayList<>();

        for (String numStr : numberStrings) {
            int num = Integer.parseInt(numStr.trim());
            inputNumberList.add(num);
        }

        return inputNumberList;
    }

    public int inputBonusNumber() {
        System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
