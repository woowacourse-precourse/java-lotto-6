package lotto.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import lotto.dto.RequestCash;
import lotto.dto.RequestWinnerLotto;

import lotto.parser.Parser;

import lotto.validator.InputValidator;


import static lotto.view.InputViewMessage.INPUT_CASH_MESSAGE;
import static lotto.view.InputViewMessage.INPUT_WINNER_NUMBER_MESSAGE;
import static lotto.view.InputViewMessage.INPUT_BONUS_NUMBER;


public class InputView {

    public RequestCash requestCash() throws IllegalArgumentException, IllegalStateException {
        try {
            System.out.println(INPUT_CASH_MESSAGE.getMessage());
            final String requestCash = getInput();
            final Integer cash = Parser.parseInt(requestCash);
            return RequestCash.of(cash);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Integer> requestWinnerNumbers() throws IllegalArgumentException, IllegalStateException  {
        try {
            System.out.println();
            System.out.println(INPUT_WINNER_NUMBER_MESSAGE.getMessage());
            final String requestWinnerNumbers = getInput();
            InputValidator.validateCommaAtEdge(requestWinnerNumbers);
            final List<String> numberDummy = Parser.parseNumberDummy(requestWinnerNumbers);
            InputValidator.validateNumbers(numberDummy);
            InputValidator.validateInputNumbersFormat(numberDummy);
            InputValidator.validateNumbersSize(numberDummy);
            InputValidator.validateDuplicatedNumber(numberDummy);
            return Parser.parseNumbers(numberDummy);
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer requestBonusNumber() throws IllegalArgumentException, IllegalStateException {
        try {
            System.out.println();
            System.out.println(INPUT_BONUS_NUMBER.getMessage());
            final String requestBonusNumber = getInput();
            InputValidator.validateRangeNumber(requestBonusNumber);
            InputValidator.validateNumber(requestBonusNumber);
            return Parser.parseInt(requestBonusNumber);
        } catch (Exception e) {
            throw e;
        }
    }


    private String getInput() throws IllegalStateException {
        try {
            final String input = Console.readLine();
            InputValidator.validateBlank(input);
            return input;
        } catch (IllegalStateException e) {
            throw e;
        }
    }


    public void close() {
        Console.close();
    }
}
