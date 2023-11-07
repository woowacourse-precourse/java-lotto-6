package lotto.views;

import lotto.GroupedLottoMatchResult;
import lotto.constants.IntegerConstants;
import lotto.constants.StringConstants;

public class WinningResultView implements View {
    private final GroupedLottoMatchResult mr;

    public WinningResultView(GroupedLottoMatchResult mr) {
        this.mr = mr;
    }

    @Override
    public void render() {
        System.out.println(StringConstants.WINNING_RESULT_MESSAGE);
        System.out.println(StringConstants.WINNING_RESULT_SEPARATOR);
        System.out.printf(StringConstants.MATCH_RESULT_MESSAGE + "\n", IntegerConstants.MATCH_THREE,
                IntegerConstants.MATCH_THREE_REWARD);
        System.out.printf(StringConstants.MATCH_RESULT_MESSAGE + "\n", IntegerConstants.MATCH_FOUR,
                IntegerConstants.MATCH_FOUR);
        System.out.printf(StringConstants.MATCH_RESULT_MESSAGE + "\n", IntegerConstants.MATCH_FIVE,
                IntegerConstants.MATCH_FIVE_REWARD);
        System.out.printf(StringConstants.MATCH_RESULT_WITH_BONUS_MESSAGE + "\n", IntegerConstants.MATCH_FIVE,
                IntegerConstants.MATCH_FIVE_BONUS_REWARD);
        System.out.printf(StringConstants.MATCH_RESULT_MESSAGE + "\n", IntegerConstants.MATCH_SIX,
                IntegerConstants.MATCH_SIX_REWARD);
        System.out.printf(StringConstants.MATCH_RESULT_PROFIT_RATE + "\n", mr.getProfitRate());
    }
}
