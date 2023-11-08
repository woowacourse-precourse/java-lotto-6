package lotto.model;

import static lotto.view.ExceptionMessages.IS_NOT_MATCHED;
import static lotto.view.ExceptionMessages.NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class WinningLottoNumbers {

    private List<Integer> numbers;

    public WinningLottoNumbers(String inputNumber) {
        while (true) {
            try {
                this.numbers = parsingWinNumbers(inputNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                inputNumber = Console.readLine(); // 다시 입력 받음
            }
        }
    }

    private List<Integer> parsingWinNumbers(String winnerNumbers) {
        String[] split = winnerNumbers.split(",");
        validate(split);

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .toList();
    }

    private void validate(String[] splitNumbers) {
        String regex = "^[1-9]|[1-3][0-9]|4[0-5]$";

        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException(NUMBER_SIZE.getMessage());
        }

        for (String numberStr : splitNumbers) {
            if (!numberStr.matches(regex)) {
                throw new IllegalArgumentException(IS_NOT_MATCHED.getMessage());
            }
        }
    }

    public List<Integer> getList() {
        return numbers;
    }
}
