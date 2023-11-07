package lotto.domain.enums;

import static java.lang.String.format;
import static lotto.domain.enums.ExceptionMessage.SYSTEM_ERROR;
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

import java.util.Arrays;
import java.util.function.UnaryOperator;
import lotto.domain.MatchingResult;
import lotto.exception.LottoGameException;

public enum WinningGrade {
    
    CORRECT_ZERO_NUMBER(ZERO, CORRECT_ZERO_NUMBER_PRICE, (always) -> true),
    CORRECT_ONE_NUMBER(ONE, CORRECT_ONE_NUMBER_PRICE, (always) -> true),
    CORRECT_TWO_NUMBERS(TWO, CORRECT_TWO_NUMBERS_PRICE, (always) -> true),
    CORRECT_THREE_NUMBERS(THREE, CORRECT_THREE_NUMBERS_PRICE, (always) -> true),
    CORRECT_FOUR_NUMBERS(FOUR, CORRECT_FOUR_NUMBERS_PRICE, (always) -> true),
    CORRECT_FIVE_NUMBERS(FIVE, CORRECT_FIVE_NUMBERS_PRICE,
            (incorrectBonusNumber) -> !incorrectBonusNumber),
    CORRECT_FIVE_NUMBERS_WITH_BONUS_NUMBER(FIVE, CORRECT_FIVE_NUMBERS_WITH_BONUS_NUMBER_PRICE,
            (correctBonusNumber) -> correctBonusNumber),
    CORRECT_SIX_NUMBERS(SIX, CORRECT_SIX_NUMBERS_PRICE, (always) -> true);
    
    private final MatchingCount matchingCount;
    private final WinningPrize price;
    private final UnaryOperator<Boolean> matchingBonus;
    
    WinningGrade(
            MatchingCount matchingCount, WinningPrize price, UnaryOperator<Boolean> matchingBonus) {
        
        this.matchingCount = matchingCount;
        this.price = price;
        this.matchingBonus = matchingBonus;
    }
    
    public static WinningGrade receiveLottoRank(MatchingResult lottoMatchingResult) {
        return Arrays.stream(WinningGrade.values())
                .filter(grade -> lottoMatchingResult.isSameMatchingCount(grade.matchingCount))
                .filter(grade -> lottoMatchingResult.isBonusMatching(grade.matchingBonus))
                .findFirst()
                .orElseThrow(() -> LottoGameException.from(SYSTEM_ERROR));
    }
    
    public boolean incorrectFiveNumbersWithBonusNumber() {
        return matchingBonus.apply(false);
    }
    
    public long receiveMultipleValue(long value) {
        return price.receiveMultipleValue(value);
    }
    
    public boolean isGreaterThanStartLottoCount() {
        return matchingCount.isGreaterThanStartLottoCount();
    }
    
    private String receiveFormattedPrice() {
        return price.receiveFormattedPrice();
    }
    
    public String receiveRankingMessageFormat(final String message, final long count) {
        return format(message,
                matchingCount.getCount(),
                receiveFormattedPrice(),
                count);
    }
}
