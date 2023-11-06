package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String input = Console.readLine();
        validatePurchaseAmount(input);
        return Integer.parseInt(input) / 1000;
    }

    private void validatePurchaseAmount(String input) {
        String trimmed = input.trim();
        InputValidator.validateIsNotBlank(trimmed);
        InputValidator.validateIsNumbers(trimmed);
        InputValidator.validateIsMultipleOf1000(trimmed);
    }

    public void printLotteryAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.", amount);
        System.out.println();
    }

    public void printLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public List<Integer> inputWinningNumbers() {
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        System.out.println(INPUT_WINNING_NUMBERS);
        String input = Console.readLine();
        validateWinningNumbers(input);
        String[] split = input.split(",");

        for (String s : split) {
            winningNumbers.add(Integer.parseInt(s));
        }
        return winningNumbers;
    }

    private void validateWinningNumbers(String input) {
        InputValidator.validateIsNotBlank(input);
        String[] split = input.split(",");
        InputValidator.validateStringArrayLength(split, 6);
        InputValidator.validateIsNumbers(split);
        for (String s : split) {
            InputValidator.validateNumberInRange(Integer.parseInt(s), 1, 45);
        }

        InputValidator.validateIsUnique(Arrays.asList(split));
    }
}
