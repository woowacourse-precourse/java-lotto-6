package domain;

import camp.nextstep.edu.missionutils.Console;
import exception.LottoExceptionMessages;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    public List<Integer> winningNumbersService() {

        List<Integer> winningNumbers = null;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                String inputValue = Console.readLine();
                String[] splitInputValues = inputValue.split(",");
                winningNumbers = validateAndParseNumbers(splitInputValues);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Lotto lotto = new Lotto(winningNumbers);
        return lotto.getNumbers();

    }

    private List<Integer> validateAndParseNumbers(String[] splitInputValues) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String value : splitInputValues) {
            try {
                int number = Integer.parseInt(value.trim());
                parsedNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(LottoExceptionMessages.NOT_A_NATURAL_NUMBER.getMessage());

            }
        }
        return parsedNumbers;
    }

}