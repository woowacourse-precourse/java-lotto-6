package lotto.Lotto.service;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Lotto.model.UIMessageGroup.*;
import static lotto.LottoPlayer.model.ExceptionGroup.*;

//UI 담당 로직
public class UIService {
    //일련의 로또 번호를 읽어들이는 함수
    public List<Integer> readLottoNumbers() {
        System.out.println(WINNING_NUMBER.getMessage());
        String numbersInput = readLine();
        validateLottoNumbers(numbersInput);
        List<Integer> numbers =
                Arrays.stream(numbersInput.split(","))
                        .map(Integer::parseInt)
                        .toList();
        validateDuplication(numbers);
        return numbers;
    }

    private void validateLottoNumbers(String input) {
        if (input.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException(NOT_VALID_ERROR.getMessage());
        }
        int number = Integer.parseInt(input);
        if (number >= 1 && number <= 45) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }
    }

    //하나의 로또 번호를 입력받는 함수
    public int readLottoNumber(List<Integer> winningLotto) {
        System.out.println(BONUS_NUMBER.getMessage());
        String numberInput = readLine();
        validateLottoNumber(numberInput, winningLotto);
        int number = Integer.parseInt(numberInput);
        return number;
    }

    private void validateLottoNumber(String input, List<Integer> winningLotto) {
        int number = Integer.parseInt(input);
        if (number >= 1 && number <= 45) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR.getMessage());
        }
        if (winningLotto.contains(number)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR.getMessage());
        }

    }
}
