package domain;

import camp.nextstep.edu.missionutils.Console;
import exception.LottoException;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    public void winningNumbersService(List<List<Integer>> totalLottoTickets) {

        String inputValue = Console.readLine();
        String[] splitInputValues = inputValue.split(",");

        List<Integer> winningNumbers = validateAndParseNumbers(splitInputValues);

        Lotto lotto = new Lotto(winningNumbers);


    }

    private List<Integer> validateAndParseNumbers(String[] splitInputValues) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String value : splitInputValues) {
            try {
                int number = Integer.parseInt(value.trim());
                parsedNumbers.add(number);
            } catch (NumberFormatException e) {
                // 입력 값이 정수가 아닌 경우 예외를 발생시킴
                throw new LottoException(LottoException.ERROR_NOT_A_NATURAL_NUMBER);
            }
        }
        return parsedNumbers;
    }

}
