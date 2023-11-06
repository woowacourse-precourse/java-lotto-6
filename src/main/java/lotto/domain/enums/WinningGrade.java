package lotto.domain.enums;

import static lotto.domain.enums.MatchingCount.FIVE;
import static lotto.domain.enums.MatchingCount.FOUR;
import static lotto.domain.enums.MatchingCount.ONE;
import static lotto.domain.enums.MatchingCount.SIX;
import static lotto.domain.enums.MatchingCount.THREE;
import static lotto.domain.enums.MatchingCount.TWO;
import static lotto.domain.enums.MatchingCount.ZERO;
import static lotto.domain.enums.WinningPrize.CORRECT_FIVE_NUMBERS_PRICE;
import static lotto.domain.enums.WinningPrize.CORRECT_FIVE_NUMBERS_WITH_BONUS_NUMBER_PRICE;
import static lotto.domain.enums.WinningPrize.CORRECT_FOUR_NUMBERS_PRICE;
import static lotto.domain.enums.WinningPrize.CORRECT_ONE_NUMBER_PRICE;
import static lotto.domain.enums.WinningPrize.CORRECT_SIX_NUMBERS_PRICE;
import static lotto.domain.enums.WinningPrize.CORRECT_THREE_NUMBERS_PRICE;
import static lotto.domain.enums.WinningPrize.CORRECT_TWO_NUMBERS_PRICE;
import static lotto.domain.enums.WinningPrize.CORRECT_ZERO_NUMBER_PRICE;
import static lotto.exception.ExceptionMessage.SYSTEM_ERROR;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import lotto.domain.MatchingResult;
import lotto.exception.LottoGameException;

public enum WinningGrade {

    CORRECT_ZERO_NUMBER(ZERO, (always) -> true, CORRECT_ZERO_NUMBER_PRICE),
    CORRECT_ONE_NUMBER(ONE, (always) -> true, CORRECT_ONE_NUMBER_PRICE),
    CORRECT_TWO_NUMBERS(TWO, (always) -> true, CORRECT_TWO_NUMBERS_PRICE),
    CORRECT_THREE_NUMBERS(THREE, (always) -> true, CORRECT_THREE_NUMBERS_PRICE),
    CORRECT_FOUR_NUMBERS(FOUR, (always) -> true, CORRECT_FOUR_NUMBERS_PRICE),
    CORRECT_FIVE_NUMBERS(FIVE, (incorrectBonusNumber) -> !incorrectBonusNumber, CORRECT_FIVE_NUMBERS_PRICE),
    CORRECT_FIVE_NUMBERS_WITH_BONUS_NUMBER(
            FIVE, (correctBonusNumber) -> correctBonusNumber, CORRECT_FIVE_NUMBERS_WITH_BONUS_NUMBER_PRICE),
    CORRECT_SIX_NUMBERS(SIX, (always) -> true, CORRECT_SIX_NUMBERS_PRICE);

    private final MatchingCount matchingCount;
    private final UnaryOperator<Boolean> matchingBonus;
    private final WinningPrize price;

    WinningGrade(MatchingCount matchingCount, UnaryOperator<Boolean> matchingBonus, WinningPrize price) {
        this.matchingCount = matchingCount;
        this.matchingBonus = matchingBonus;
        this.price = price;
    }

    public static WinningGrade receiveLottoRank(MatchingResult lottoMatchingResult) {
        return Arrays.stream(WinningGrade.values())
                .filter(grade -> lottoMatchingResult.isSameMatchingCount(grade.matchingCount))
                .filter(grade -> lottoMatchingResult.isBonusMatching(grade.matchingBonus))
                .findFirst()
                .orElseThrow(() -> LottoGameException.from(SYSTEM_ERROR));
    }

    public long getMatchingCount() {
        return matchingCount.getCount();
    }

    public boolean incorrectFiveNumbersWithBonusNumber() {
        return matchingBonus.apply(false);
    }

    public long getPrice() {
        return price.getPrice();
    }
}
