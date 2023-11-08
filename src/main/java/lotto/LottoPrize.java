package lotto;

public enum LottoPrize { // 일치 여부에 따라 당첨금을 가지는 enum 클래스를 생성
    NO_PRIZE(0), // 2이하의 개수가 일치하면 0원
    THREE_MATCH(5000), // 3개가 일치하면 5000원
    FOUR_MATCH(50000), // 4개가 일치하면 50000원
    FIVE_MATCH(1500000), // 5개가 일치하면 1500000원
    FIVE_MATCH_WITH_BONUS(30000000), // 5개와 보너스 번호가 일치하면 30000000원
    SIX_MATCH(2000000000); // 6개가 일치하면 2000000000원
    private final int prizeAmount;
    LottoPrize(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }
    public int getPrizeAmount() { // 당첨금을 리턴한다
        return prizeAmount;
    }
}
