package lotto.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String VALIDATE_NUMBER_CODE = "-?\\\\d+";
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final String ENTER_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String STANDARD_OF_SPLIT = ",";
    private static final String ENTER_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int enterPurchaseAmounts() {
        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
        String userInput = readLine();

        int purchaseAmounts = parsingPurchaseAmounts(userInput);
        validatePurchaseAmounts(purchaseAmounts);

        return purchaseAmounts;
    }

    private static int parsingPurchaseAmounts(String userInput) {
        if (!userInput.matches(VALIDATE_NUMBER_CODE)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다. 다시 입력해주세요.");
        }
        return Integer.parseInt(userInput);
    }

    private static void validatePurchaseAmounts(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
           throw new IllegalArgumentException("[ERROR] 로또는 장당 1000원 입니다. 다시 입력해주세요.");
        }
    }

    public static List<Integer> enterWinningNumbers() {
        System.out.println();
        System.out.println(ENTER_WINNING_NUMBERS_MESSAGE);

        String userInput = readLine();

        List<Integer> winningNumbers = Arrays.stream(userInput.split(STANDARD_OF_SPLIT))
                .map(InputView::parsingWinningNumbers)
                .toList();

        validateWinningNumbersSize(winningNumbers);

        return winningNumbers;
    }

    private static int parsingWinningNumbers(String userInput) {
        if (!userInput.matches(VALIDATE_NUMBER_CODE)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다. 다시 입력해주세요.");
        }

        return Integer.parseInt(userInput);
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다. 다시 입력해주세요.");
        }
    }

    public static int enterBonusNumber() {
        System.out.println();
        System.out.println(ENTER_BONUS_NUMBERS_MESSAGE);

        String userInput = readLine();
        int bonusNumber = parsingBonusNumber(userInput);

        return bonusNumber;
    }

    private static int parsingBonusNumber(String userInput) {
        if (!userInput.matches(VALIDATE_NUMBER_CODE)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1개의 숫자여야 합니다. 다시 입력해주세요.");
        }

        return Integer.parseInt(userInput);
    }
}
