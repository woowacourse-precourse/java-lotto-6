package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.system.validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR = ",";

    private enum InputMessage {
        REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        InputMessage(String message) {
            this.message = message;
        }
    }

    private final Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public int inputPurchaseAmount() {
        while (true) {
            System.out.println(InputMessage.REQUEST_PURCHASE_AMOUNT.message);
            String userInputNumber = Console.readLine();

            try {
                validator.validatePurchaseAmount(userInputNumber);

                return Integer.parseInt(userInputNumber);
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    public List<Integer> inputWinningNumbers() {
        while (true) {
            System.out.println(InputMessage.REQUEST_WINNING_NUMBERS.message);
            String userInputBeforeSplit = Console.readLine();
            List<String> userInputNumbers = Arrays.asList(userInputBeforeSplit.split(SEPARATOR));

            try {
                validator.validateWinningNumbers(userInputNumbers);

                return userInputNumbers.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }

    public int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println(InputMessage.REQUEST_BONUS_NUMBER.message);
            String userInputNumber = Console.readLine();

            try {
                validator.validateBonusNumber(winningNumbers, userInputNumber);

                return Integer.parseInt(userInputNumber);
            } catch (IllegalArgumentException validationFailure) {
                System.out.println(validationFailure.getMessage());
            }
        }
    }
}
