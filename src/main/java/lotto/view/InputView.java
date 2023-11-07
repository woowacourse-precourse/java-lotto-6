package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;
import lotto.domain.WinnerLotto;
import lotto.parser.Parser;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.CharacterUnits.COMMA;
import static lotto.util.CharacterUnits.ENTER;
import static lotto.view.InputViewMessage.*;

public class InputView {

    public Cash inputCash() throws IllegalArgumentException, IllegalStateException {
        try {
            System.out.println(INPUT_CASH_MESSAGE.getMessage());
            final String requestCash = getInput();
            final Integer cash = Parser.parseInt(requestCash);
            return new Cash(cash);
        } catch (Exception e) {
            throw e;
        }
    }
    public List<Integer> inputWinnerNumbers() throws IllegalArgumentException, IllegalStateException {
        try {
            System.out.println();
            System.out.println(INPUT_WINNER_NUMBER_MESSAGE.getMessage());
            final String requestWinnerNumbers = getInput();
            final List<String> numberDummy = Parser.parseNumberDummy(requestWinnerNumbers);
            InputValidator.validateInputNumbersFormat(numberDummy);
            return Parser.parseNumbers(numberDummy);
        } catch (Exception e) {
            throw e;
        }
    }
    public Integer inputBonusNumber() throws IllegalArgumentException, IllegalStateException {
        try {
            System.out.println();
            System.out.println(INPUT_BONUS_NUMBER.getMessage());
            final String requestBonusNumber = getInput();
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
