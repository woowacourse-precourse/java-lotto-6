package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;
import lotto.domain.WinnerLotto;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.CharacterUnits.COMMA;

public class InputView {

    public Cash InputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = getInput();
        InputValidator.validateNumber(input);
        Integer cash = Integer.parseInt(input);
        return new Cash(cash);
    }


    public List<Integer> inputWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = getInput();
        List<String> splitInput = splitByComma(input);
        InputValidator.validateInputNumbersFormat(splitInput);
        return splitInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = getInput();
        InputValidator.validateNumber(input);
        System.out.println();
        return Integer.parseInt(input);
    }



    private List<String> splitByComma(String input) {
        return Arrays.stream(input
                        .split(COMMA.getUnit()))
                        .toList();
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
