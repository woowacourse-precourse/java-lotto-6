package lotto.domain;

public enum RankingStatus {
    FIRST_RANK(2000000000,"6개 번호 일치"),
    SECOND_RANK(30000000,"5개 번호 일치 + 보너스 번호 일치"),
    THIRD_RANK(1500000,"5개 번호 일치"),
    FORTH_RANK(50000,"4개 번호 일치"),
    FIFTH_RANK(5000,"3개 번호 일치"),
    BOOM(0,"꽝");

    public int reward;
    public String message;
    RankingStatus(int reward, String message) {
        this.reward = reward;
        this.message = message;
    }
}
