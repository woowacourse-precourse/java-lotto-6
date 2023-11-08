package lotto.generator;

import lotto.domain.result.LottoResult;
import lotto.option.EqualStatus;

public class LottoResultGenerator {
    private LottoResultGenerator() {
    }

    public static LottoResult setEqualStatus(int equalCount, int bonusCount) {
        if (isThreeEqual(equalCount, bonusCount)) {
            return new LottoResult(EqualStatus.THREE_EQUAL);
        }
        if (isFourEqual(equalCount, bonusCount)) {
            return new LottoResult(EqualStatus.FOUR_EQUAL);
        }
        if (isFiveEqual(equalCount, bonusCount)) {
            return new LottoResult(EqualStatus.FIVE_EQUAL);
        }
        if (isFiveEqualAndBonus(equalCount, bonusCount)) {
            return new LottoResult(EqualStatus.FIVE_AND_BONUS_EQUAL);
        }
        if (isSixEqual(equalCount, bonusCount)) {
            return new LottoResult(EqualStatus.SIX_EQUAL);
        }
        return null;
    }

    private static boolean isThreeEqual(int equalCount, int bonusCount) {
        if (equalCount + bonusCount == 3) {
            return true;
        }
        return false;
    }

    private static boolean isFourEqual(int equalCount, int bonusCount) {
        if (equalCount + bonusCount == 4) {
            return true;
        }
        return false;
    }

    private static boolean isFiveEqual(int equalCount, int bonusCount) {
        if (equalCount + bonusCount == 5) {
            return true;
        }
        return false;
    }

    private static boolean isFiveEqualAndBonus(int equalCount, int bonusCount) {
        if (equalCount + bonusCount == 6) {
            if (bonusCount == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSixEqual(int equalCount, int bonusCount) {
        if (equalCount + bonusCount == 6) {
            if (bonusCount == 0) {
                return true;
            }
        }
        return false;
    }
}
