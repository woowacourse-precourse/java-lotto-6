package lotto.domain.lotto;

import java.util.List;
import lotto.domain.lottoresult.LottoResult;

public class WinLotto extends Lotto {
    private static final String BONUS_NUMBER_DUPLICATE_ERROR = "보너스 넘버와 당첨 번호는 동일할 수 없습니다.";
    private final BonusNumber bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumberInLottoNumbers(numbers, bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validateBonusNumberInLottoNumbers(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR);
        }
    }

    public LottoResult getLottoResult(Lotto lotto) {
        int numberOfSame = compareLottoNumber(lotto);
        boolean matchWithBonusNumber = compareWithBonusNumber(lotto);
        return LottoResult.getResult(numberOfSame, matchWithBonusNumber);
    }

    int compareWithLottoNumber(Lotto lotto) {
        return compareLottoNumber(lotto);
    }

    boolean compareWithBonusNumber(Lotto lotto) {
        return bonusNumber.checkLottoContainBonusNumber(lotto);
    }
}
