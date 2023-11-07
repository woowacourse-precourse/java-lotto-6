package lotto.views;

import java.util.List;
import lotto.constants.StringConstants;
import lotto.domain.LottoMatch;
import lotto.domain.LottoMatchType;

public class LottoMatchResultView implements View<Void> {
    private final LottoMatch lottoMatch;

    public LottoMatchResultView(LottoMatch lottoMatch) {
        this.lottoMatch = lottoMatch;
    }

    @Override
    public Void render() {
        System.out.println(StringConstants.WINNING_RESULT_MESSAGE);
        System.out.println(StringConstants.WINNING_RESULT_SEPARATOR);

        List<LottoMatchType> queries = List.of(LottoMatchType.MATCH_THREE, LottoMatchType.MATCH_FOUR,
                LottoMatchType.MATCH_FIVE, LottoMatchType.MATCH_FIVE_BONUS, LottoMatchType.MATCH_SIX);

        for (var query : queries) {
            System.out.println(lottoMatch.getStatusString(query));
        }
        System.out.printf(StringConstants.MATCH_RESULT_PROFIT_RATE + "\n", lottoMatch.getProfitRate());
        return null;
    }
}
