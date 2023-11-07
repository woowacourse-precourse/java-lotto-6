package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public int inputMoney() {
        int moneyInput = 0;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                moneyInput = Integer.parseInt(Console.readLine().replaceAll("\\s", ""));
                InputValidator.checkDivisibleBy1000(moneyInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moneyInput;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String WinningNumbersInput = Console.readLine();
        String[] winningNumbers = WinningNumbersInput.split(",");
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String numberString : winningNumbers) {
            winningLottoNumbers.add(Integer.parseInt(numberString.trim()));
        }
        return winningLottoNumbers;
    }
}
