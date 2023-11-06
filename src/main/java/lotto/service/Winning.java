package lotto.service;

import lotto.service.errorchek.ErrorCheck;
import lotto.fixeddata.NumberData;
import lotto.fixeddata.Text;
import lotto.util.io.output.viewer.UserScreen;
import lotto.util.io.output.viewer.Viewer;

public enum Winning {
    IRSTWINNING(Text.LOTTO_NUMBER_SIX_MATCHES, 6, NumberData.FIRST_PRIZE_MONEY),
    SECONDWINNING(Text.LOTTO_NUMBER_FIVE_BOUNS_NUMBER_MATCHES, 5, NumberData.SECOND_PRIZE_MONEY),
    THIRDWINNING(Text.LOTTO_NUMBER_FIVE_MATCHES, 5, NumberData.THIRD_PRIZE_MONEY),
    FOURTHWINNING(Text.LOTTO_NUMBER_FOUR_MATCHES, 4, NumberData.FOURTH_PRIZE_MONEY),
    FIFTHWINNING(Text.LOTTO_NUMBER_THREE_MATCHES, 3, NumberData.FIFTH_PRIZE_MONEY),
    ZERO(null, 0, 0);

    static Viewer output = new UserScreen();

    private final String textmatch;
    private final int matchwinningcountnumber;
    private final long prize;

    Winning(String matchnumber, int matchwinningcountnumber, long prize) {
        this.textmatch = matchnumber;
        this.matchwinningcountnumber = matchwinningcountnumber;
        this.prize = prize;

    }

    public void PrintWinnging(int count) {
        if (this == ZERO) {
            return;
        }
        output.ViewPrint(this.textmatch + count + Text.LOTTO_PIECES);
    }

    private boolean matchCount(int matchwinningcountnumber) {
        return this.matchwinningcountnumber == matchwinningcountnumber;
    }

    public long GetWinningPrize() {
        return prize;
    }

    public static Winning valueOf(int matchwinningcountnumber, boolean matchbonusnumber) {
        if (matchwinningcountnumber < NumberData.WINNING_MIN_COUNT) {
            return ZERO;
        }

        if (SECONDWINNING.matchCount(matchwinningcountnumber) && matchbonusnumber) {
            return SECONDWINNING;
        }

        for (Winning winning : values()) {
            if (winning.matchCount(matchwinningcountnumber) && winning != SECONDWINNING) {
                return winning;
            }
        }
        ErrorCheck.WinningValueOf();
        return null;        //ErrorCheck.WinningValueOf();로 가면 바로 NullPointerException로 예외처리됨 null이어도 영향없음.
    }
}
