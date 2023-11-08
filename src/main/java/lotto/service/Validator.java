package lotto.service;

import java.util.List;

public class Validator {
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;

    public static void validateAmount(String amount) {
        if (!isNumbers(amount)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자이어야 합니다.");
        }
        if (!isValidateAmount(amount)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000 단위이어야 합니다.");
        }
    }

    private static boolean isNumbers(String amount) {
        return amount.matches("\\d+");
    }

    private static boolean isValidateAmount(String amount) {
        return Integer.parseInt(amount) > 0 || Integer.parseInt(amount) % 1000 == 0;
    }

    public static void validateBonusNumber(List<Integer> winnerNumbers, int bonusNumber) {
        if (!isNotDuplicateNumber(winnerNumbers, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복되면 안됩니다.");
        }
        if (!isBetweenLottoRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static boolean isNotDuplicateNumber(List<Integer> winnerNumbers, int bonusNumber) {
        winnerNumbers.add(bonusNumber);
        return winnerNumbers.size() == winnerNumbers.stream().distinct().count();
    }

    private static boolean isBetweenLottoRange(int bonusNumber) {
        return bonusNumber >= LOTTO_GAME_START_NUMBER && bonusNumber <= LOTTO_GAME_END_NUMBER;
    }
}
