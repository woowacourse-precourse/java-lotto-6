package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputResolver {
    private static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final int PRICE_PER_QUANTITY = 1000;

    public Integer getPriceInput() {
        printMessage(PRICE_INPUT_MESSAGE);
        Integer price = Integer.parseInt(readLine());
        printMessage("");
        return price;
    }

    public Integer getPurchaseQuantity(Integer price) {
        Integer quantity = price / PRICE_PER_QUANTITY;
        printMessage(quantity + PURCHASE_QUANTITY_MESSAGE);
        return quantity;
    }

    public List<Integer> getWinningNumbersInput() throws InvalidInputException {
        printMessage(WINNING_NUMBERS_INPUT_MESSAGE);
        String numbersInput = readLine();
        List<Integer> winningNumbers = Arrays.stream(numbersInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public Integer getBonusNumberInput() {
        printMessage(BONUS_NUMBER_INPUT_MESSAGE);
        Integer bonus = Integer.parseInt(readLine());
        return bonus;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
