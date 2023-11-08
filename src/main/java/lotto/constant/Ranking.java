package lotto.constant;

import static lotto.constant.LottoMessage.FIFTH_PLACE_MESSAGE;
import static lotto.constant.LottoMessage.FIRST_PLACE_MESSAGE;
import static lotto.constant.LottoMessage.FOURTH_PLACE_MESSAGE;
import static lotto.constant.LottoMessage.LOSE_MESSAGE;
import static lotto.constant.LottoMessage.SECOND_PLACE_MESSAGE;
import static lotto.constant.LottoMessage.THIRD_PLACE_MESSAGE;
import static lotto.constant.LottoRuleConstant.FIFTH_PLACE_BONUS_MATCH;
import static lotto.constant.LottoRuleConstant.FIFTH_PLACE_PRIZE_MONEY;
import static lotto.constant.LottoRuleConstant.FIFTH_PLACE_WINNER_NUMBER_MATCH_COUNT;
import static lotto.constant.LottoRuleConstant.FIRST_PLACE_BONUS_MATCH;
import static lotto.constant.LottoRuleConstant.FIRST_PLACE_PRIZE_MONEY;
import static lotto.constant.LottoRuleConstant.FIRST_PLACE_WINNER_NUMBER_MATCH_COUNT;
import static lotto.constant.LottoRuleConstant.FOURTH_PLACE_BONUS_MATCH;
import static lotto.constant.LottoRuleConstant.FOURTH_PLACE_PRIZE_MONEY;
import static lotto.constant.LottoRuleConstant.FOURTH_PLACE_WINNER_NUMBER_MATCH_COUNT;
import static lotto.constant.LottoRuleConstant.LOSE_PRIZE_MONEY;
import static lotto.constant.LottoRuleConstant.LOSE_WINNER_NUMBER_MATCH_COUNT;
import static lotto.constant.LottoRuleConstant.SECOND_PLACE_BONUS_MATCH;
import static lotto.constant.LottoRuleConstant.SECOND_PLACE_PRIZE_MONEY;
import static lotto.constant.LottoRuleConstant.SECOND_PLACE_WINNER_NUMBER_MATCH_COUNT;
import static lotto.constant.LottoRuleConstant.THIRD_PLACE_BONUS_MATCH;
import static lotto.constant.LottoRuleConstant.THIRD_PLACE_PRIZE_MONEY;
import static lotto.constant.LottoRuleConstant.THIRD_PLACE_WINNER_NUMBER_MATCH_COUNT;

import java.util.Arrays;
import java.util.Objects;
import lotto.model.CompareResult;

public enum Ranking {
    FIFTH_PLACE(
            new CompareResult(FIFTH_PLACE_WINNER_NUMBER_MATCH_COUNT, FIFTH_PLACE_BONUS_MATCH),
            FIFTH_PLACE_PRIZE_MONEY,
            FIFTH_PLACE_MESSAGE
    ),
    FOURTH_PLACE(
            new CompareResult(FOURTH_PLACE_WINNER_NUMBER_MATCH_COUNT, FOURTH_PLACE_BONUS_MATCH),
            FOURTH_PLACE_PRIZE_MONEY,
            FOURTH_PLACE_MESSAGE
    ),
    THIRD_PLACE(
            new CompareResult(THIRD_PLACE_WINNER_NUMBER_MATCH_COUNT, THIRD_PLACE_BONUS_MATCH),
            THIRD_PLACE_PRIZE_MONEY,
            THIRD_PLACE_MESSAGE
    ),
    SECOND_PLACE(
            new CompareResult(SECOND_PLACE_WINNER_NUMBER_MATCH_COUNT, SECOND_PLACE_BONUS_MATCH),
            SECOND_PLACE_PRIZE_MONEY,
            SECOND_PLACE_MESSAGE
    ),
    FIRST_PLACE(
            new CompareResult(FIRST_PLACE_WINNER_NUMBER_MATCH_COUNT, FIRST_PLACE_BONUS_MATCH),
            FIRST_PLACE_PRIZE_MONEY,
            FIRST_PLACE_MESSAGE
    ),
    LOSE(new CompareResult(LOSE_WINNER_NUMBER_MATCH_COUNT, FIFTH_PLACE_BONUS_MATCH),
            LOSE_PRIZE_MONEY,
            LOSE_MESSAGE
    );

    private CompareResult compareResult;
    private int prizeMoney;
    private String message;

    Ranking(CompareResult compareResult, int prizeMoney, String message) {
        this.compareResult = compareResult;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static Ranking findByCompareResult(CompareResult compareResult) {
        int winningNumberMatchCount = compareResult.getWinningNumberMatchCount();

        if (winningNumberMatchCount == 5) {
            return Arrays.stream(Ranking.values())
                    .filter(ranking -> ranking.matchAllWinningNumberMatchCountAndBonusMatch(compareResult)).findAny()
                    .orElse(LOSE);
        }

        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchWinningNumberMatchCount(winningNumberMatchCount)).findAny()
                .orElse(LOSE);
    }

    private boolean matchAllWinningNumberMatchCountAndBonusMatch(CompareResult compareResult) {
        return matchWinningNumberMatchCount(compareResult.getWinningNumberMatchCount()) && matchBonusMatch(
                compareResult.getBonusMatch());
    }

    private boolean matchWinningNumberMatchCount(int winningNumberMatchCount) {
        return Objects.equals(compareResult.getWinningNumberMatchCount(), winningNumberMatchCount);
    }

    private boolean matchBonusMatch(boolean bonusMatch) {
        return Objects.equals(compareResult.getBonusMatch(), bonusMatch);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }
}
