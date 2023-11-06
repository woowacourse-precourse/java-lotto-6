package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;
import lotto.domain.WinnerLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public Cash InputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = getInput();
        validateBlank(input);
        validateNumber(input);
        Integer cash = parseStrToInt(input);
        validateAvailableCash(cash);
        return new Cash(cash);
    }

    private void validateNumber(String input) {
        for (char token : input.toCharArray()) {
            if (!Character.isDigit(token)) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력할 수 없습니다. 숫자를 입력해주세요");
            }
        }
    }

    private void validateAvailableCash(Integer input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지는 금액만 입력가능합니다");
        }
    }

    private void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백을 입력할 수 없습니다.");
        }
    }

    private Integer parseStrToInt(String number) {
        return Integer.parseInt(number);
    }

    public WinnerLotto inputWinnerLotto() {
        List<Integer> winnerNumbers = inputWinnerNumbers();
        Integer bonusNumber = inputBonusNumber();
        return new WinnerLotto(winnerNumbers, bonusNumber);
    }

    public List<Integer> inputWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = getInput();
        validateBlank(input);
        List<String> inputWinnerNumbers = Arrays.stream(
                        input.split(","))
                        .toList();
        validateCountOfWinnerNumbers(inputWinnerNumbers);
        validateNumbers(inputWinnerNumbers);
        List<Integer> winnerNumbers = convertStrToInt(inputWinnerNumbers);
        validateDuplicatedNumber(winnerNumbers);
        validateNumbersRange(winnerNumbers);
        System.out.println();
        return winnerNumbers;
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = getInput();
        validateBlank(input);
        validateNumber(input);
        Integer number = parseStrToInt(input);
        validateNumberRange(number);
        System.out.println();
        return number;
    }

    private void validateCountOfWinnerNumbers(List<String> inputWinnerNumbers) {
        if (inputWinnerNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자로 구성 되야합니다");
        }
    }

    private void validateNumbers(List<String> inputWinnerNumbers) {
        for (String inputWinnerNumber : inputWinnerNumbers) {
            validateNumber(inputWinnerNumber);
        }
    }

    private void validateDuplicatedNumber(List<Integer> winnerNumbers) {
        if (winnerNumbers.stream()
                .collect(Collectors.toSet())
                .size() != winnerNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다");
        }
    }

    private void validateNumberRange(Integer number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 1~45를 벗어난 숫자를 입력할 수 없습니다");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }


    private List<Integer> convertStrToInt(List<String> inputWinnerNumbers) {
        return inputWinnerNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    //

    private String getInput() throws IllegalStateException {
       String input = Console.readLine();
       validateNoLineFound(input);
       return input;
    }

    private void validateNoLineFound(String input) throws IllegalStateException {
        if (input.isBlank() || input == null) {
            throw new IllegalStateException("[ERROR] 입력값을 입력하지 않았습니다.");
        }
    }

    public void close() {
        Console.close();
    }
}
