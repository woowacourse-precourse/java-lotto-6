package lotto.model;

import java.text.NumberFormat;
import java.util.Arrays;

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

    public static String getMessage(Rank rank, int counts) {
        RankMessage rankMessage = findBy(rank);
        return String.format(rankMessage.message, toAmountFormat(getReward(rank)), counts);
    }

    private static RankMessage findBy(Rank rank) {
        return Arrays.stream(values())
                .filter(rankMessage -> rankMessage.rank == rank)
                .findFirst()
                .orElse(NONE_MESSAGE);
    }

    private static int getReward(Rank rank) {
        return RankReward.getRewardOf(rank);
    }

    private static String toAmountFormat(int reward) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        return numberFormat.format(reward);
    }
}
