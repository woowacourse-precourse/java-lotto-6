package lotto.view;

import static lotto.constant.ConstantString.BONUS_NUMBER_INIT_MESSAGE;
import static lotto.constant.ConstantString.LUCKY_NUMBER_INIT_MESSAGE;
import static lotto.constant.ConstantString.PURCHASE_PRICE_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoApplicationException;
import lotto.validator.InputValidator;

public class InputView {

    private final InputValidator inputValidator;
    private String validateInput;
    private List<String> validateLuckyNumbers;
    private Integer validateBonusNumber;

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

    public List<Integer> writeLuckyNumber() {
        printWhiteSpace();
        print(LUCKY_NUMBER_INIT_MESSAGE);
        validateLuckyNumber();
        return convertLuckyNumberForm(this.validateLuckyNumbers);
    }

    public void validateLuckyNumber() {
        while (!validLuckyNumber()) {
        }
    }

    private boolean validLuckyNumber() {
        try {
            validateInput = removeWhitespace(Console.readLine());
            inputValidator.validateNotNull(validateInput);
            validateLuckyNumbers = inputValidator.separateInput(validateInput);
            inputValidator.validateLuckyNumberIsNumber(validateLuckyNumbers);
            return true;
        } catch (LottoApplicationException e) {
            e.getErrorMessage();
            return false;
        }
    }

    public List<Integer> convertLuckyNumberForm(List<String> validateLuckyNumbers) {
        return validateLuckyNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer writeBonusNumber() {
        printWhiteSpace();
        print(BONUS_NUMBER_INIT_MESSAGE);
        validateBonusNumber();
        return validateBonusNumber;
    }

    private void validateBonusNumber(){
        while (!validBonusNumber()){
        }
    }

    private boolean validBonusNumber() {
        try{
            String bonusNumber = removeWhitespace(Console.readLine());
            inputValidator.validateNotNull(bonusNumber);
            inputValidator.validateNumber(bonusNumber);
            validateBonusNumber = Integer.parseInt(bonusNumber);
            return true;
        }catch (LottoApplicationException e){
            e.getErrorMessage();
            return false;
        }
    }

    private void printWhiteSpace(){
        System.out.println();
    }

}
