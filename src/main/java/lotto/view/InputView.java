package lotto.view;

import static lotto.constants.ExceptionMessage.BLANK_INPUT;
import static lotto.constants.ExceptionMessage.ERROR_FORMAT;
import static lotto.constants.ExceptionMessage.SPACE_INCLUDED;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validation;

public class InputView {

    public String inputPurchaseCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputCost = Console.readLine();
        validateInput(inputCost);
        return inputCost;
    }

    public String inputWinnerNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNum = Console.readLine();
        validateInput(inputWinningNum);
        Validation.validateComma(inputWinningNum);
        return inputWinningNum;
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNum = Console.readLine();
        validateInput(inputBonusNum);
        return inputBonusNum;
    }

    public void validateInput(String input) {
        validateBlankInput(input);
        validateSpaceChar(input);
    }
    public void validateBlankInput(String input) {

        if (input.isBlank()) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, BLANK_INPUT+input));
        }
    }
    public void validateSpaceChar(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, SPACE_INCLUDED+input));
        }
    }
}