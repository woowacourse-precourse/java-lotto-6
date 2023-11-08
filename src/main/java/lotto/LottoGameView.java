package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Collections;
import java.util.List;

import static lotto.Constants.*;

public class LottoGameView {

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String input = "";
        input = Console.readLine();
        try {
            validatePurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchaseAmount();
        }

        return Integer.parseInt(input);
    }

    private void validatePurchaseAmount(String input) {
        String trimmed = input.trim();
        InputValidator.validateIsNotBlank(trimmed);
        InputValidator.validateIsNumbers(trimmed);
        InputValidator.validateIsMultipleOf1000(trimmed);
    }

    public void printLotteryAmount(int amount) {
        System.out.printf(PURCHASE_RESULT, amount);
    }

    public void printLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public WinningNumbers inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        String numbers = Console.readLine();
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBERS);
        String bonus = Console.readLine();
        WinningNumbers winningNumbers = null;
        try {
            winningNumbers = new WinningNumbers(numbers, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinningNumbers();
        }
        return winningNumbers;
    }

    public void printResult(List<Prize> result) {
        int fifth = Collections.frequency(result, Prize.Fifth);
        int forth = Collections.frequency(result, Prize.Forth);
        int third = Collections.frequency(result, Prize.Third);
        int second = Collections.frequency(result, Prize.Second);
        int first = Collections.frequency(result, Prize.First);

        System.out.println(WINNING_RESULT);
        System.out.printf(LOTTERY_RESULT, Prize.Fifth.getCount(), Prize.Fifth.getMoneyString(), fifth);
        System.out.printf(LOTTERY_RESULT, Prize.Forth.getCount(), Prize.Forth.getMoneyString(), forth);
        System.out.printf(LOTTERY_RESULT, Prize.Third.getCount(), Prize.Third.getMoneyString(), third);
        System.out.printf(LOTTERY_RESULT_WITH_BONUS, Prize.Second.getCount(), Prize.Second.getMoneyString(), second);
        System.out.printf(LOTTERY_RESULT, Prize.First.getCount(), Prize.First.getMoneyString(), first);
    }

    public void printRateReturn(double rateReturn) {
        System.out.printf(RETURN_RATE, rateReturn);
    }
}
