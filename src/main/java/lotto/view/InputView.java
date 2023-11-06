package lotto.view;

import static lotto.constant.Constant.PURCHASE_PRICE_MESSAGE;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoApplicationException;
import lotto.validator.InputValidator;

public class InputView {

    private final InputValidator inputValidator;
    private String validateInput;

    public InputView() {
        inputValidator = new InputValidator();
    }

    public String writePurchasePrice() {
        print(PURCHASE_PRICE_MESSAGE);
        validateInput();
        return validateInput;
    }

    public void validateInput(){
        while(!validate()){
        }
    }

    public boolean validate() {
        try {
            validateInput = removeWhitespace(Console.readLine());
            inputValidator.validateNotNull(validateInput);
            inputValidator.validateNumber(validateInput);
            inputValidator.validateMaxPrice(validateInput);
            inputValidator.validatePurchasePrice(validateInput);
            return true;
        } catch (LottoApplicationException e) {
            e.getErrorMessage();
            return false;
        }
    }

    public String removeWhitespace(String input) {
        return Stream.of(input)
                .flatMap(userInput -> userInput.chars()
                        .mapToObj(element -> (char) element)
                        .filter(element -> !Character.isWhitespace(element))
                        .map(String::valueOf))
                .collect(Collectors.joining());
    }


    private void print(String message) {
        System.out.println(message);
    }

}
