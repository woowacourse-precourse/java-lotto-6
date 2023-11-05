package domain;

import camp.nextstep.edu.missionutils.Console;
import exception.LottoExceptionMessages;

import java.util.List;

public class BonusNumber {

    public int bonusNumberService(List<Integer> winningNumbers) {
        while (true) {
            try {
                String inputValue = Console.readLine();
                int bonusNumber = Integer.parseInt(inputValue);
                isNumberInRange(bonusNumber);
                isNumberUnique(bonusNumber, winningNumbers);
                return bonusNumber; // 유효한 번호가 입력되면 반복을 종료하고 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void isNumberInRange(int number) {
        if (number < 1 || number > 45) {

            throw new IllegalArgumentException(LottoExceptionMessages.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private static void isNumberUnique(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(LottoExceptionMessages.DUPLICATE_NUMBERS.getMessage());
        }
    }
}
