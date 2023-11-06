package lotto.domain.user;

import java.util.List;

public class BonusNumber {
    private static Integer bonusNumber;
    private static List<Integer> winningNumber;

    public BonusNumber(List<Integer> winningNumber, String number) {
        this.winningNumber = winningNumber;
        validate(number);
        bonusNumber = Integer.parseInt(number);
    }

    private static void validate(String number) {
        validateIsNumber(number);
        validateIsNumberInRange(number);
        validateIsUniqueNumber(number);
    }

    private static void validateIsNumber(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateIsNumberInRange(String number) {
        boolean IsNumberInRange = (Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 45);
        if(!IsNumberInRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateIsUniqueNumber(String number) {
        boolean isDuplicated = winningNumber.contains(Integer.parseInt(number));
        if(isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
