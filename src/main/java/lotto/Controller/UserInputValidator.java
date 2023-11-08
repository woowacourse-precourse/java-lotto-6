package lotto.Controller;

import java.util.HashSet;
import java.util.List;

public class UserInputValidator {


    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 다른 번호여야 합니다.");
        }
    }

    public static void validateLottoNumber(int number) {
        if (number < LottoConfig.NUMBER_RANGE_START.getValue() || number > LottoConfig.NUMBER_RANGE_END.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.NUMBERS_PER_TICKET.getValue() || new HashSet<>(numbers).size() != LottoConfig.NUMBERS_PER_TICKET.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
    }

}
