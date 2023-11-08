package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoInput {

    protected List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        boolean isValid;

        do {
            String input = Console.readLine();
            isValid = parseAndValidateNumbers(input, winningNumbers);
        } while (!isValid);

        return winningNumbers;
    }

    private boolean parseAndValidateNumbers(String input, List<Integer> winningNumbers) {
        String[] numbers = input.split(",");
        try {
            List<Integer> parsedNumbers = parseNumbers(numbers);
            validateNumbers(parsedNumbers);
            winningNumbers.addAll(parsedNumbers);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
        return false;
    }

    private List<Integer> parseNumbers(String[] numbers) throws NumberFormatException {
        List<Integer> num = new ArrayList<>();
        for (String value : numbers) {
            int number = Integer.parseInt(value.trim());
            num.add(number);
        }
        return num;
    }

    private void validateNumbers(List<Integer> numbers) throws IllegalArgumentException {
        new Lotto(numbers);
    }
}
