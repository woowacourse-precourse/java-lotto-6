package domain;

import static message.ErrorMessage.CANT_DUPLICATE_NUMBER;
import static message.ErrorMessage.LOTTO_NUMBER_RANGE;
import static view.InputView.inputBonusNumber;

import java.util.regex.Pattern;

public class WinningLotto {
    public static final Pattern lottoPattern = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private int validate(Lotto lotto, int bonusNumber) {
        if (!validateDuplicate(lotto, bonusNumber) || !validateRange(bonusNumber)) {
            return validate(lotto, inputBonusNumber());
        }
        return bonusNumber;
    }

    private boolean validateDuplicate(Lotto lotto, int bonusNumber) {
        try {
            if (lotto.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(CANT_DUPLICATE_NUMBER.getErrorMessage());
            return false;
        }
        return true;
    }

    private boolean validateRange(int bonusNumber) {
        try {
            if (!lottoPattern.matcher(Integer.toString(bonusNumber)).matches()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LOTTO_NUMBER_RANGE.getErrorMessage());
            return false;
        }
        return true;
    }

    public static Rank getMatchCounts(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = Lotto.getMatchCounts(lotto, winningLotto.lotto);
        boolean bonus = lotto.contains(winningLotto.bonusNumber);

        return Rank.getRank(matchCount, bonus);
    }
}
