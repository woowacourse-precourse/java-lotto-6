package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.Constants;
import lotto.Lotto;

public class GetWinningNumbersUI {

    private String enterWinningNumbersUI() {

        System.out.println();
        System.out.println(Constants.ENTER_WINNING_NUMBERS);

        return readLine();
    }

    private String enterBonusNumberUI() {
        System.out.println();
        System.out.println(Constants.ENTER_BONUS_NUMBER);

        return readLine();
    }

    private static void isValidBonusNumber(Lotto winningLotto, Integer bonusNumber) {
        List<Integer> winningNumbers = winningLotto.getLotto();

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto getWinningNumbers() {
        String input = enterWinningNumbersUI();
        String[] inputNumbers = input.split(",");

        List<Integer> numbers = new ArrayList<>();
        int number;

        for (String s : inputNumbers) {
            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            numbers.add(number);
        }

        return new Lotto(numbers);
    }

    public Integer getBonusNumbers(Lotto winningLotto) {
        String input = enterBonusNumberUI();
        int bonusNumber;

        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (bonusNumber >= 1 && bonusNumber <= 45) {
            isValidBonusNumber(winningLotto, bonusNumber);
            return bonusNumber;
        }

        throw new IllegalArgumentException();
    }
}
