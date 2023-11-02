package lotto;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public static int amountValidator(String amount) {

        int validAmount = validNumber(amount);

        negativeNumber(validAmount);

        return validAmount;

    }

    public static List<Integer> numbersValidator(String numbers) {

        numbers = numbers.replace(" ", "");
        List<String> eachNumbers = List.of(numbers.split(","));
        List<Integer> lottoNumbers = new ArrayList<>();

        for (String number : eachNumbers) {
            int verifiedNum = validNumber(number);
            validOverlap(lottoNumbers, verifiedNum);
            validRange(verifiedNum);
            lottoNumbers.add(verifiedNum);
        }
        validLen(lottoNumbers);

        return lottoNumbers;
    }

    public static int bonusValidator(List<Integer> lottoNumbers, String bonus) {

        int bonusNumber = validNumber(bonus);

        validRange(bonusNumber);
        validOverlap(lottoNumbers, bonusNumber);

        return bonusNumber;

    }

    private static void validLen(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validOverlap(List<Integer> numbers, int num) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자 입니다. : " + num);
        }
    }

    private static void validRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 범위를 벗어난 숫자입니다. : " + num);
        }
    }

    private static int validNumber(String num) {
        int number;
        try {
            number = Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다. : " + num);
        }
        return number;
    }

    private static void negativeNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("[ERROR] 음수를 입력받았습니다. : " + num);
        }
    }

}
