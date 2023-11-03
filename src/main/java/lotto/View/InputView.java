package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public String inputPurchaseAmount() {
        String amount = Console.readLine();
        return amount;
    }

    public List<Integer> inputWinningNumbers() {
        List<String> winningNumbersStr = List.of(Console.readLine().split(","));
        if (String.join("", winningNumbersStr).isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 비었습니다.");
        }

        List<Integer> winningNumbers = new ArrayList<>();
        try {
            for (int i = 0; i < winningNumbersStr.size(); i++) {
                winningNumbers.add(Integer.parseInt(winningNumbersStr.get(i)));
            }
            return winningNumbers;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    public String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
