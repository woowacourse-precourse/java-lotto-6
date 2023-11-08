package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.Constants.*;

public class LottoGameView {

    public int inputPurchaseAmount() {
        while (true) {
            System.out.println(INPUT_PURCHASE_AMOUNT);
            String input = Console.readLine();
            try {
                validatePurchaseAmountInput(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmountInput(String input) {
        InputValidator.validateIsNotBlank(input);
        InputValidator.validateIsNumbers(input);
        InputValidator.validateIsMultipleOf(input, LOTTERY_PRICE);
    }

    public void inputWinningNumbers(WinningNumbers winningNumbers) {
        while (true) {
            System.out.println(INPUT_WINNING_NUMBERS);
            String input = Console.readLine();
            System.out.println();
            try {
                validateWinningNumbersInput(input);
                List<Integer> numbers = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
                winningNumbers.setNumbers(numbers);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumbersInput(String input) {
        InputValidator.validateIsNotBlank(input);
        String[] split = input.split(",");
        InputValidator.validateIsNumbers(split);
    }

    public void inputBonusNumbers(WinningNumbers winningNumbers) {
        while (true) {
            System.out.println(INPUT_BONUS_NUMBERS);
            String bonus = Console.readLine();
            try {
                validateBonusNumberInput(bonus);
                winningNumbers.setBonus(Integer.parseInt(bonus));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumberInput(String input) {
        InputValidator.validateIsNotBlank(input);
        InputValidator.validateIsNumbers(input);
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
