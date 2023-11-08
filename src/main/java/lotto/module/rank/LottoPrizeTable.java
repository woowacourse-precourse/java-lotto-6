package lotto.module.rank;

import lotto.module.rank.impl.*;

public enum LottoPrizeTable {
    FIFTH_PLACE(FifthPlace.getSingleton(), "3개 일치 (5,000원) - "),
    FOURTH_PLACE(FourthPlace.getSingleton(), "4개 일치 (50,000원) - "),
    THIRD_PLACE(ThirdPlace.getSingleton(), "5개 일치 (1,500,000원) - "),
    SECOND_PLACE(SecondPlace.getSingleton(), "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PLACE(FirstPlace.getSingleton(), "6개 일치 (2,000,000,000원) - ");

    private final Rank rank;
    private final String winningRecordMessage;

    LottoPrizeTable(Rank rank, String winningRecordMessage) {
        this.rank = rank;
        this.winningRecordMessage = winningRecordMessage;
    }

    public int getPrize() {
        return rank.getPrize();
    }

    public int getMatchCount() {
        return rank.getMatchCount();
    }

    public Rank getRank() {
        return rank;
    }

    public String getWinningRecordMessage() {
        return winningRecordMessage;
    }

}
