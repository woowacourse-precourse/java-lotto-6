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

public class InputView {

    public Cash InputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = getInput();
        Integer cash = Parser.parseInt(input);
        return new Cash(cash);
    }


    public List<Integer> inputWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = getInput();
        List<String> numberDummy = Parser.parseNumberDummy(input);
        InputValidator.validateInputNumbersFormat(numberDummy);
        return Parser.parseNumbers(numberDummy);
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = getInput();
        return Parser.parseInt(input);
    }




    private String getInput() {
        String input = Console.readLine();
        InputValidator.validateBlank(input);
        return input;
    }


    public void close() {
        Console.close();
    }
}
