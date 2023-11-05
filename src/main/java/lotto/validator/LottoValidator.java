package lotto.validator;

import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LottoValidator {

    private LottoValidator() {
    }

    public static void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이어야 합니다.");
        }
    }

    public static void validateUniqueLottoNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호들은 중복되지 않아야 합니다.");
        }
    }

    public static void validateLottoNumbersRange(List<Integer> numbers) {
        Optional<Integer> outOfRangeNumber = numbers.stream()
                .filter(LottoValidator::isOutOfLottoNumberRange)
                .findAny();
        if (outOfRangeNumber.isPresent()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 중 하나이어야 합니다.");
        }
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < Lotto.PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또는 1개 이상 구매해야 합니다.");
        }
        if (purchaseAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다.");
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 존재하지 않아야 합니다.");
        }
        if (isOutOfLottoNumberRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 중 하나이어야 합니다.");
        }
    }

    private static boolean isOutOfLottoNumberRange(int value) {
        return value < Lotto.MINIMUM_NUMBER || value > Lotto.MAXIMUM_NUMBER;
    }
}
