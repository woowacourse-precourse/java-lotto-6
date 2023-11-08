package lotto;

public enum Result {
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1500000,"5개 일치 (1,500,000원)"),
    SECOND(5, true, 30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)")
    ;

    private final int matchCount;
    private final boolean matchBonus;
    private final int reward;
    private final String message;
    private int count;

    Result(int matchCount, int reward, String message) {
        this(matchCount, false, reward, message, 0);
    }

    Result(int matchCount, boolean matchBonus, int reward, String message) {
        this(matchCount, matchBonus, reward, message, 0);
    }

    Result(int matchCount, boolean matchBonus, int reward, String message, int count) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.reward = reward;
        this.message = message;
        this.count = count;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }

    public boolean isMatching(int matchedCount, boolean isMatchedBonus) { //몇 개 일치하는지, 보너스 번호가 일치하는지 확인하는 메서드
        return this.matchCount == matchedCount && this.matchBonus == isMatchedBonus;
    }

    public void plusCount() {
        this.count++;
    } // 당첨된 로또 갯수를 증가하는 메서드
}
