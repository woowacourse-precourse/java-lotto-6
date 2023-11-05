package lotto.domain;


import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIFTH(3,5000, "3개 일치 (5,000원)"),
    FOURTH(4,50000, "4개 일치 (50,000원)"),
    THIRD(5,1500000, "5개 일치 (1,500,000원)"),
    SECOND(5,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6,2000000000, "6개 일치 (2,000,000,000원)");

    Rank(int count, int amount, String message) {
        this.count = count;
        this.amount = amount;
        this.message = message;
    }

    /**
     * 당첨 순위에 대해 카운팅을 위한 맵 생성
     */
    public static final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
    static {
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    /**
     * 키값 중복으로 2등의 경우, 후처리하며 카운트 키값으로 조회성 ranking 맵을 생성한다.
     */
    private static final Map<Integer, Rank> ranking = new HashMap<>() {{
        put(FIFTH.count, FIFTH);
        put(FOURTH.count, FOURTH);
        put(THIRD.count, THIRD);
        put(FIRST.count, FIRST);
    }};

    private final int count;
    private final int amount;
    private final String message;


    public static void addRankCount(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
    }

    public static void minusThirdRankCount() {
        rankCount.put(Rank.THIRD, rankCount.get(Rank.THIRD) - 1);
    }

    public static int getRankCount(Rank rank) {
        return rankCount.get(rank);
    }

    public static double getTotalEarning() {
        int totalEarning = 0;
        for (Rank rank : Rank.values()) {
            totalEarning += rank.amount * getRankCount(rank);
        }
        return totalEarning;
    }

    public static Rank getRank(int count) {
        return ranking.get(count);
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }
}
