package lotto;

import java.util.List;

public class BonusNumber {
    private static int number = 0;
    private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 중복된 숫자가 발생했습니다.";
    private static final String ERROR_NUMBER = "[ERROR] 숫자를 입력하세요.";

    public BonusNumber(List<Integer> lottoNumber, String bonus) {
        checkNumber(bonus);
        duplicateNumber(lottoNumber,bonus);
        number = Integer.parseInt(bonus);
    }

    private void duplicateNumber(List<Integer> lottoNumber, String bonus) {
        int bonusNumber = Integer.parseInt(bonus);
        boolean isPresent = lottoNumber.stream()
                .anyMatch(number->number==bonusNumber);

        if(isPresent) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    private void checkNumber(String bonus) {
        boolean isNumber = bonus.chars().allMatch(Character::isDigit);

        if(!isNumber) {
            throw new IllegalArgumentException(ERROR_NUMBER);
        }
    }

    public int bonusNumber() {
        return number;
    }
}
