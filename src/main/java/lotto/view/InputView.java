package lotto.view;

import static lotto.message.ErrorMessage.BONUS_DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.message.ErrorMessage.COMMA_BASED_EXCEPTION_MESSAGE;
import static lotto.message.ErrorMessage.INSUFFICIENT_FUNDS_EXCEPTION_MESSAGE;
import static lotto.message.ErrorMessage.NUMBER_INPUT_EXCEPTION_MESSAGE;
import static lotto.message.MessageConstants.COMMA;
import static lotto.message.MessageConstants.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.message.MessageConstants.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static lotto.message.MessageConstants.INPUT_WINNING_NUMBERS_MESSAGE;
import static lotto.message.MessageConstants.ONE_THOUSAND;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class InputView {
    public int inputPrice() {
        while (true) {
            System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);

            try {
                int inputPrice = parseInputNumber(Console.readLine());
                validatePurchaseAbility(inputPrice);
                return inputPrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAbility(int inputPrince) {
        if (inputPrince < ONE_THOUSAND) {
            throw new IllegalArgumentException(INSUFFICIENT_FUNDS_EXCEPTION_MESSAGE);
        }
    }

    public Lotto getWinningNumbers() {
        while (true) {
            System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);

            try {
                List<Integer> inputWinningNumbers = inputWinningNumbers();
                return new Lotto(inputWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputWinningNumbers() {
        try {
            return Arrays.stream(Console.readLine().split(COMMA))
                    .map(number -> parseInputNumber(number.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COMMA_BASED_EXCEPTION_MESSAGE);
        }
    }

    public int getBonusNumber(Lotto winningNumbers) {
        while (true) {
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

            try {
                int inputBonusNumber = parseInputNumber(Console.readLine());
                duplicationBonusNumber(winningNumbers.getNumbers(), inputBonusNumber);
                return inputBonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int parseInputNumber(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NUMBER_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private void duplicationBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }
    
}
