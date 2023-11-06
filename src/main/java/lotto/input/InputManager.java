package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.data.BonusNumber;
import lotto.data.PurchaseAmount;
import lotto.data.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public static PurchaseAmount inputPurchaseAmount() {
        String input;
        while (true) {
            try {
                input = Console.readLine();
                InputValidator.checkPurchaseAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return new PurchaseAmount(Integer.parseInt(input));
    }

    public static WinningNumbers inputWinningNumbers() {
        String input;
        while (true) {
            try {
                input = Console.readLine();
                InputValidator.checkWinningNumbers(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String[] split = input.split(",");

        List<Integer> winningNumbers = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            winningNumbers.add(Integer.parseInt(split[i]));
        }

        return new WinningNumbers(winningNumbers);
    }


    public static BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        String input;
        while (true) {
            try {
                input = Console.readLine();
                InputValidator.checkBonusNumber(input, winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return new BonusNumber(Integer.parseInt(input));
    }
}
