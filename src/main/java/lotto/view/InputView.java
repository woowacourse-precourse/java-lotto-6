package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    Console console;

    public int readPurchasingAmount() {
        String purchasingAmount = console.readLine();
        return Integer.parseInt(purchasingAmount) / 1000;
    }

    public List<Integer> readWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        String readNumbers = console.readLine();
        String[] splitNumbers = readNumbers.split(",");

        for (String splitNumber : splitNumbers) {
            int number = Integer.parseInt(splitNumber);
            winningNumbers.add(number);
        }

        return winningNumbers;
    }

    public int readBonusNumber() {
        String readNumber = console.readLine();
        return Integer.parseInt(readNumber);
    }

}
