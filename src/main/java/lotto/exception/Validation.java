package lotto.exception;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoPurchaseManager;

import java.util.List;

public class Validation {

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Lotto.getLottoSize()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리의 숫자여야 합니다.");
        }
    }

    public static void validateLottoDuplication(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();

        if (count != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다.");
        }
    }

    public static void validateWinningNumberRange(int number) {
        if (number < LottoNumber.getLottoNumberMinRange() || number > LottoNumber.getLottoNumberMaxRange()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateWinningAndBonusNumberDuplication(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호와 로또 보너스 번호는 서로 중복되지 않는 숫자여야 합니다.");
        }
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LottoPurchaseManager.getLottoTicketPrice() != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 로또 티켓 가격인 1,000원 단위로 구매가 가능합니다.");
        }
    }
}
