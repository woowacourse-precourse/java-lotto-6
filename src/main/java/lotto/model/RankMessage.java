package lotto.model;

import java.text.NumberFormat;

public enum RankMessage {
    FIRST_MESSAGE(Rank.FIRST, "6개 일치 %s - %d개"),
    SECOND_MESSAGE(Rank.SECOND, "5개 일치, 보너스 볼 일치 %s - %d개"),
    THIRD_MESSAGE(Rank.THIRD, "5개 일치 %s - %d개"),
    FOURTH_MESSAGE(Rank.FOURTH, "4개 일치 %s - %d개"),
    FIFTH_MESSAGE(Rank.FIFTH, "3개 일치 %s - %d개"),
    NONE_MESSAGE(Rank.NONE, "");

    private final Rank rank;
    private final String message;

    RankMessage(Rank rank, String message) {
        this.rank = rank;
        this.message = message;
    }

    public String getMessage(int counts) {
        return String.format(message, toAmountFormat(getReward()), counts);
    }

    private int getReward() {
        return RankReward.getRewardOf(rank);
    }

    private String toAmountFormat(int reward) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return numberFormat.format(reward);
    }
}
