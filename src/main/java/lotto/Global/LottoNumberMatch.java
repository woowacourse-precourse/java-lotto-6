package lotto.Global;

public enum LottoNumberMatch {
    FIFTH_RESULT(3, MatchType.NO),
    FOURTH_RESULT(4, MatchType.NO),
    THIRD_RESULT(5, MatchType.FALSE),
    SECOND_RESULT(5, MatchType.TRUE),
    FIRST_RESULT(6, MatchType.NO);

    private int winningNumberMatch;
    private MatchType matchType;

    private LottoNumberMatch(int winningNumberMatch, MatchType matchType) {
        this.winningNumberMatch = winningNumberMatch;
        this.matchType = matchType;
    }

    public int getWinningNumber() {
        return LottoNumberMatch.valueOf(name()).winningNumberMatch;
    }

    public MatchType getMatchType() {
        return LottoNumberMatch.valueOf(name()).matchType;
    }
}
