package lotto.util;

import lotto.model.BonusNumber;
import lotto.model.Winning;

import java.util.List;

import static lotto.util.NumberException.duplicateException;
import static lotto.util.NumberException.numberOfRangeException;
import static lotto.util.WinnigCheck.checkCommaCount;
import static lotto.util.WinnigCheck.checkNumberLength;

public class WinningException {
    public static Winning winningException(List<Integer> numbers, String inputWinning) throws IllegalArgumentException {
        winningNumberRotate(numbers);
        winningNumberLengthException(numbers);
        duplicateException(numbers);
        winningNumberCommaException(inputWinning);
        return new Winning(numbers);
    }

    public static void winningNumberLengthException(List<Integer> numbers) throws IllegalArgumentException {
        if (!checkNumberLength(numbers)) {
            throw new IllegalArgumentException("[ERROR] : 총 6개의 로또번호를 입력하세요");
        }
    }

    public static void winningNumberCommaException(String inputWinning) throws IllegalArgumentException{
        if (!checkCommaCount(inputWinning)) {
            throw new IllegalArgumentException("[ERROR] : 구분자는 숫자당 하나입니다.");
        }
    }

    public static void winningNumberRotate(List<Integer> winningNumbers) throws IllegalArgumentException{
        for (int number : winningNumbers) {
            numberOfRangeException(number);
        }
    }
    public static BonusNumber bonusException(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        numberOfRangeException(bonus);
        duplicateException(numbers, bonus);
        return new BonusNumber(bonus);
    }
}
