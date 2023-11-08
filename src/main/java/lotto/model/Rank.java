package lotto.model;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    NO_RANK(0, 0, "-")
    ;

    private final int match;
    private final int prize;
    private final String message;

    Rank(int match, int prize, String message) {
        this.match = match;
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getMessage() {
        return this.message;
    }

    public static Rank result(int matchCnt, boolean bonus) {

        if(matchCnt == FIRST.match) {
            return FIRST;
        } else if(matchCnt == SECOND.match && bonus) {
            return SECOND;
        } else if(matchCnt == THIRD.match) {
            return THIRD;
        } else if(matchCnt == FOURTH.match) {
            return FOURTH;
        } else if(matchCnt == FIFTH.match) {
            return FIFTH;
        }

        return NO_RANK;
    }

    public static Map<Rank, Integer> initResultRepo() {
        Map<Rank, Integer> resultRepo = new HashMap<>();
        for(Rank rank : Rank.values()) {
            resultRepo.put(rank, 0);
        }

        return resultRepo;
    }

    public static int calculatePrize(Map<Rank, Integer> result) {
        int totalPrize = 0;

        for(Rank rank : result.keySet()) {
            totalPrize += rank.prize * result.get(rank);
        }

        return totalPrize;
    }
}
