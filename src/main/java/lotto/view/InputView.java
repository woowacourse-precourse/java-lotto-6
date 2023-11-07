package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.exception.InputExceptionConstant;
import lotto.util.InputValidator;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_SPLITTER = ",";

    public String inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println(ASK_PURCHASE_AMOUNT);
                String input = readLine();
                InputValidator.validatePurchaseNumber(input);

                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING);
            }
        }
    }

    public String[] inputWinningNumbers() {
        while (true) {
            try {
                System.out.println(ASK_WINNING_NUMBERS);
                String[] inputNumbers = readLine().split(INPUT_SPLITTER);
                InputValidator.isNaturalNumbers(inputNumbers);

                return inputNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING_ARRAY.getText());
            }
        }
    }

    public String inputBonusNumber() {
        while (true) {
            try {
                System.out.println(ASK_BONUS_NUMBER);
                String input = readLine();
                InputValidator.isOneNaturalNumber(input);

                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(InputExceptionConstant.ONLY_NATURAL_NUMBER_IN_STRING.getText());
            }
        }
    }
}
