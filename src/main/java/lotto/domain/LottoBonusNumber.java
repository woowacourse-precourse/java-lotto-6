package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import lotto.utils.NumberUtil;

public class LottoBonusNumber {

    public static final String BONUS_NUMBER_VALID_LOG = "보너스 번호는 로또 번호와 중복이 불가합니다.";
    private static final int DUPLICATE_FLAG_NUMBER = 1;
    private final int bonusNumber;

    public LottoBonusNumber(final int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public LottoBonusNumber(final String bonusNumber) {
        this(NumberUtil.parseInt(bonusNumber));
    }

    public static LottoBonusNumber validateLottoNumDuplicate(final Lotto lotto,
                                                             final LottoBonusNumber lottoBonusNumber) {
        Set<Integer> allNumbers = new HashSet<>(lotto.getNumbers());
        allNumbers.add(lottoBonusNumber.getBonusNumber());

        if (allNumbers.size() < lotto.getNumbers().size() + DUPLICATE_FLAG_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_VALID_LOG);
        }
        return lottoBonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
