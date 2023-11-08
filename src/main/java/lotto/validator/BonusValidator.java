package lotto.validator;

import lotto.domain.WinningLotto;

import java.util.List;

public class BonusValidator {

    private static final int BONUS_MIN_NUMBER = 1;
    private static final int BONUS_MAX_NUMBER = 45;

    public static void validate(String input, List<Integer> winningLotto) {
        validateNonNumber(input);
        validateRange(input);
        validateDuplicateWithWiningNumber(input, winningLotto);
    }

    private static void validateNonNumber(String input) {
        String regExp = "^[0-9-]+$";
        if (!input.matches(regExp)){
            throw new IllegalArgumentException("[ERROR] 입력 값에 숫자 이외의 값이 들어오면 안됩니다.");
        }
    }

    private static void validateRange(String input) {
        int number = Integer.parseInt(input);
        if (number < BONUS_MIN_NUMBER || number > BONUS_MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이여야 합니다.");
        }
    }

    private static void validateDuplicateWithWiningNumber(String input, List<Integer> winningLotto) {
        int number = Integer.parseInt(input);
        if (winningLotto.contains(number)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복일 수 없습니다.");
        }
    }

}
